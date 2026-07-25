package com.hardik.pagepulse.service;

import com.hardik.pagepulse.dto.AuditResponse;
import com.hardik.pagepulse.exception.NonHtmlContentException;
import com.hardik.pagepulse.exception.RequestTimeoutException;
import lombok.RequiredArgsConstructor;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.UnsupportedMimeTypeException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.net.SocketTimeoutException;
import java.net.http.HttpConnectTimeoutException;

@Service
@RequiredArgsConstructor
public class AuditService {
    private final UrlValidator urlValidator;

    public AuditResponse audit(String url) {

        urlValidator.validateUrl(url);
        try {
            long start = System.currentTimeMillis();

//            Connection.Response response = Jsoup.connect(url)
//                    .userAgent("Mozilla/5.0")
//                    .timeout(20000)
//                    .ignoreContentType(false)
//                    .execute();
            Connection.Response response = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64)")
                    .header("Accept-Language", "en-US,en;q=0.9")
                    .followRedirects(true)
                    .timeout(10000)
                    .ignoreContentType(false)
                    .execute();

            String contentType = response.contentType();
            if (contentType == null || !contentType.toLowerCase().contains("text/html")) {
                throw new NonHtmlContentException("Provided URL is not an HTML page.");
            }

            long end = System.currentTimeMillis();
            Document document = response.parse();

            String title = document.title();
            Element meta = document.selectFirst("meta[name=description]");
            String metaDescription = meta != null ? meta.attr("content") : "Not Found";
            int h1Count = document.select("h1").size();
            int imagesMissingAlt = document.select("img:not([alt]), img[alt='']").size();
            String text = document.body().text();
            int wordCount = text.isBlank()
                    ? 0 : text.trim().split("\\s+").length;

            return AuditResponse.builder()
                    .status(response.statusCode())
                    .responseTime(end - start)
                    .title(title)
                    .metaDescription(metaDescription)
                    .imagesMissingAlt(imagesMissingAlt)
                    .h1Count(h1Count)
                    .wordCount(wordCount)
                    .build();

        } catch (HttpConnectTimeoutException | SocketTimeoutException e) {
            throw new RequestTimeoutException("Website took too long to respond.");
        } catch (UnsupportedMimeTypeException e) {
            throw new NonHtmlContentException("Provided URL is not an HTML page.");
        } catch (Exception e) {
            throw new RuntimeException("Unable to audit Website");
        }
    }
}
