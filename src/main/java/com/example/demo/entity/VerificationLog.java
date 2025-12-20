package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import java.time.LocalDateTime;

@Entity
public class VerificationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "certificate_id", nullable = false)
    private Certificate certificate;

    private LocalDateTime verifiedAt;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String ipAddress;

    public enum Status {
    PENDING,
    VERIFIED,
    FAILED
}


    public VerificationLog() {
    }

    public VerificationLog(
            Certificate certificate,
            Status status,
            String ipAddress) {
        this.certificate = certificate;
        this.status = status;
        this.ipAddress = ipAddress;
        this.verifiedAt = LocalDateTime.now();
    }

    @PrePersist
    public void onCreate() {
        this.verifiedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public LocalDateTime getVerifiedAt() {
        return verifiedAt;
    }
    public void setVerifiedAt(LocalDateTime verifiedAt) {
    this.verifiedAt = verifiedAt;
}


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
