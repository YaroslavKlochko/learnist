package com.learnist.database.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationService {
    public void sendMessage(final String email, final String link) {
        log.info("Send message to: {} with link: {}", email, link);
    }
}
