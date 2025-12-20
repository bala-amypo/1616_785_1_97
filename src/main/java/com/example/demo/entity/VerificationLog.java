package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
public class VerificationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "certificate_id", nullable = false, unique = true)
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

    public VerificationLog(Certificate certificate, Status status, String ipAddress) {
        this.certificate = certificate;
        this.status = status;
        this.ipAddress = ipAddress;
        this.verifiedAt = LocalDateTime.now();
    }

    @PrePersist
    public void onCreate() {
        this.verifiedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        this.verifiedAt = LocalDateTime.now();
    }
}
