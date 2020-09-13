package com.english.learnist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

    @GetMapping(value = {"/greeting", "/"})
    public String greetingController() {
        return "greeting";
    }
}
