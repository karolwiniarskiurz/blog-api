package com.kwiniarski97.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
    @RequestMapping("/")
    public String index() {
        return "Congratulations from BlogController.java";
    }
}
