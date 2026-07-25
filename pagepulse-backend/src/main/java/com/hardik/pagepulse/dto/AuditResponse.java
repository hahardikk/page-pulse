package com.hardik.pagepulse.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuditResponse {
    private int status;
    private long responseTime;
    private String title;
    private String metaDescription;
    private int h1Count;
    private int imagesMissingAlt;
    private int wordCount;
}
