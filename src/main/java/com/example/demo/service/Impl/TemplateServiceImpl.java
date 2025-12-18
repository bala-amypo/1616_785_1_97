package com.example.demo.service.impl;

import com.example.demo.entity.CertificateTemplate;
import com.example.demo.service.TemplateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateServiceImpl implements TemplateService {

    @Override
    public CertificateTemplate addTemplate(CertificateTemplate template) {
        return template;
    }

    @Override
    public List<CertificateTemplate> getAllTemplates() {
        return List.of();
    }

    @Override
    public CertificateTemplate findById(Long id) {
        return null;
    }
}
