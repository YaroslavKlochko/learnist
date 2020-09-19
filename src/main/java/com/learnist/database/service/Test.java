package com.learnist.database.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("mikepassword"));
        //$2a$10$hOAGNhx2NlMDgOuqEtpVRuirARuD..HywjJTAVE9FEEqGkzJnnTcW
    }
}
