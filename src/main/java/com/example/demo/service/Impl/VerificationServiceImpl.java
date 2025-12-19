package com.example.demo.service.impl;

import com.example.demo.entity.VerificationLog;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.VerificationLogRepository;
import com.example.demo.service.VerificationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VerificationServiceImpl implements VerificationService {

    private final VerificationLogRepository verificationLogRepository;

    public VerificationServiceImpl(VerificationLogRepository verificationLogRepository) {
        this.verificationLogRepository = verificationLogRepository;
    }

    @Override
    public VerificationLog verifyCertificate(String verificationCode, String clientIp) {

        VerificationLog log = new VerificationLog();

        log.setVerificationCode(verificationCode);
        log.setClientIp(clientIp);
        log.setVerifiedAt(LocalDateTime.now());

        boolean isValid = verificationCode != null && !verificationCode.isBlank();

        if (isValid) {
            log.setStatus(VerificationLog.Status.VERIFIED);
        } else {
            log.setStatus(VerificationLog.Status.FAILED);
        }

        return verificationLogRepository.save(log);
    }

    @Override
    public List<VerificationLog> getLogsByCertificate(Long certificateId) {
        List<VerificationLog> logs =
                verificationLogRepository.findByCertificateId(certificateId);

        if (logs.isEmpty()) {
            throw new ResourceNotFoundException("No verification logs found");
        }

        return logs;
    }
}
