package com.learnist.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "admin")
public class AdminController {

    @GetMapping(value = "/profile")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getAdminPage() {
        return "admin";
    }
}
