package com.example.demo.controller;

import com.example.demo.entity.CertificateTemplate;
import com.example.demo.service.TemplateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TemplateController {

    private final TemplateService templateService;

    public TemplateController(TemplateService templateService) {
        this.templateService = templateService;
    }

    @PostMapping("/templates")
    public CertificateTemplate addTemplate(@RequestBody CertificateTemplate template) {
        return templateService.addTemplate(template);
    }

    @GetMapping("/templates")
    public List<CertificateTemplate> getTemplates() {
        return templateService.getAllTemplates();
    }
}
