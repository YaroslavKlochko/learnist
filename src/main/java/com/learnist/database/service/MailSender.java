package com.learnist.database.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSender {

    private final JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String username;

    public MailSender(final JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendTo(final String emailTo, final String subject, final String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom(username);
        mailMessage.setTo(emailTo);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);

        javaMailSender.send(mailMessage);
    }
}
