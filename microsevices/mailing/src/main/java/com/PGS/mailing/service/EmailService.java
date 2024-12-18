package com.PGS.mailing.service;

import org.springframework.web.multipart.MultipartFile;

public interface EmailService {
    String sendMail(MultipartFile file, String to, String subject, String body);
}