package com.kwiniarski97.controllers;

import com.kwiniarski97.models.dtos.TagDTO;
import com.kwiniarski97.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tags")
public class TagController {

    @Autowired
    TagService service;

    @GetMapping("/")
    @ResponseStatus(value = HttpStatus.OK)
    public List<TagDTO> getAvailable() {
        return service.getAvailable();
    }

    @PostMapping("/create")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.CREATED)
    public long create(@RequestBody TagDTO tag) {
        return service.create(tag);
    }
}
