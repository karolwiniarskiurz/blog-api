package com.kwiniarski97.controllers;

import com.kwiniarski97.models.domain.Author;
import com.kwiniarski97.models.domain.Post;
import com.kwiniarski97.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/create")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void create(@RequestBody Author author){
        authorService.create(author);

    }
}
