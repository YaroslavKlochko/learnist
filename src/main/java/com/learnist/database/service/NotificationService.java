package com.learnist.database.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@Slf4j
public class NotificationService {
    private final MailSender mailSender;

    public NotificationService(final MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendMessage(final String email, final String link) {
        mailSender.sendTo(email, "Reset password", format("Please follow the link to reset your password: %s", link));
    }
}
