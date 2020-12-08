package com.learnist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/dictionary")
public class DictionaryController {

    @GetMapping(value = "/list")
    public String getDictionaryList() {
        return "dictionary/list";
    }
}
