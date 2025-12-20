package com.example.demo.controller;

import com.example.demo.entity.VerificationLog;
import com.example.demo.service.VerificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VerificationController {

    private final VerificationService verificationService;

    public VerificationController(VerificationService verificationService) {
        this.verificationService = verificationService;
    }

    @PostMapping("/verify/{verificationCode}")
    public VerificationLog verifyCertificate(
            @PathVariable String verificationCode,
            @RequestHeader(value = "X-Client-IP", required = false) String clientIp) {
        return verificationService.verifyCertificate(verificationCode, clientIp);
    }

    @GetMapping("/verify/logs/{certificateId}")
    public List<VerificationLog> getLogsByCertificate(
            @PathVariable Long certificateId) {
        return verificationService.getLogsByCertificate(certificateId);
    }
}
