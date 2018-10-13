package com.kwiniarski97.controllers;

import com.kwiniarski97.models.domain.Author;
import com.kwiniarski97.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/create")
    @ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public long create(@RequestBody Author author) {
        return authorService.create(author);
    }
}
