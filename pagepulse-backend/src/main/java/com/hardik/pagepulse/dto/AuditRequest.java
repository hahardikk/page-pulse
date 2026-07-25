package com.hardik.pagepulse.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuditRequest {

    @NotBlank(message = "URL is required")
    private String url;
}
