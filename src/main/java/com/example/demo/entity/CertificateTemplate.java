package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
public class CertificateTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String templateName;

    private String backgroundUrl;
    private String fontStyle;
    private String signatureName;

    public CertificateTemplate(String templateName, String backgroundUrl, String fontStyle, String signatureName) {
        this.templateName = templateName;
        this.backgroundUrl = backgroundUrl;
        this.fontStyle = fontStyle;
        this.signatureName = signatureName;
    }
}
