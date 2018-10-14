package com.kwiniarski97.controllers;

import com.kwiniarski97.models.domain.Author;
import com.kwiniarski97.models.dtos.AuthenticateDTO;
import com.kwiniarski97.models.dtos.AuthenticationDTO;
import com.kwiniarski97.models.dtos.AuthorCreateDTO;
import com.kwiniarski97.models.dtos.AuthorDTO;
import com.kwiniarski97.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/create")
    @ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity create(@RequestBody AuthorCreateDTO author) {
        try {
            return ResponseEntity.ok(authorService.create(author));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | InvalidKeyException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/auth")
    public ResponseEntity<AuthenticationDTO> authenticate(@RequestBody AuthenticateDTO auth) {
        try {

            return ResponseEntity.ok(authorService.authenticate(auth));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping("/{id}")
    @ResponseBody
    public AuthorDTO getByID(@PathVariable(value = "id") long id){
        return authorService.getById(id);
    }
}
