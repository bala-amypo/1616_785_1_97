package com.example.demo.controller;

import com.example.demo.entity.Certificate;
import com.example.demo.service.CertificateService;
import org.springframework.web.bind.annotation.*;

@RestController
public class CertificateController {

    private final CertificateService certificateService;

    public CertificateController(CertificateService certificateService) {
        this.certificateService = certificateService;
    }

    @PostMapping("/certificates/generate/{studentId}/{templateId}")
    public Certificate generateCertificate(
            @PathVariable Long studentId,
            @PathVariable Long templateId) {
        return certificateService.generateCertificate(studentId, templateId);
    }

    @GetMapping("/certificates/{certificateId}")
    public Certificate getCertificate(@PathVariable Long certificateId) {
        return certificateService.getCertificate(certificateId);
    }

    @GetMapping("/certificates/verify/code/{verificationCode}")
    public Certificate getByVerificationCode(
            @PathVariable String verificationCode) {
        return certificateService.findByVerificationCode(verificationCode);
    }
}
