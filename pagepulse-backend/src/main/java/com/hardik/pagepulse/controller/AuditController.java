package com.hardik.pagepulse.controller;

import com.hardik.pagepulse.dto.AuditRequest;
import com.hardik.pagepulse.dto.AuditResponse;
import com.hardik.pagepulse.service.AuditService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/audit")
public class AuditController {
    private final AuditService auditService;

    @PostMapping("/post")
    public ResponseEntity<AuditResponse> audit(@Valid @RequestBody AuditRequest request){
        return ResponseEntity.ok(auditService.audit(request.getUrl()));
    }
}
