package com.learnist.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "creator")
public class CreatorController {

    @GetMapping(value = "/profile")
    @PreAuthorize("hasAuthority('can_update')")
    public String getCreatorPage() {
        return "creator";
    }
}
