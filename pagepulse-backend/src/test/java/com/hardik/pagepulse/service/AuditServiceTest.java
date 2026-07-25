package com.hardik.pagepulse.service;

import com.hardik.pagepulse.dto.AuditResponse;
import com.hardik.pagepulse.exception.InvalidUrlException;
import com.hardik.pagepulse.exception.NonHtmlContentException;
import com.hardik.pagepulse.exception.RequestTimeoutException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AuditServiceTest {
    private final UrlValidator urlValidator = new UrlValidator();
    private final AuditService auditService = new AuditService(urlValidator);

    @Test
    void shouldAuditGithubSuccessfully() {
        AuditResponse response = auditService.audit("https://github.com");

        assertEquals(200, response.getStatus());
        assertNotNull(response.getTitle());
        assertTrue(response.getWordCount() > 0);
        assertTrue(response.getResponseTime() > 0);
        assertTrue(response.getH1Count() >= 0);
        assertTrue(response.getImagesMissingAlt() >= 0);
    }

    @Test
    void shouldThrowInvalidUrlException() {
        assertThrows(InvalidUrlException.class,
                () -> auditService.audit("abc"));
    }

    @Test
    void shouldThrowNonHtmlException() {
        assertThrows(NonHtmlContentException.class,
                () -> auditService.audit("https://api.github.com"));
    }

    @Test
    void shouldThrowRequestTimeoutException() {
        assertThrows(RequestTimeoutException.class,
                () -> auditService.audit("https://10.255.255.1"));
    }
}
