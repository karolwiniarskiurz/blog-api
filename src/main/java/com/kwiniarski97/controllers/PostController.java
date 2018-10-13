package com.kwiniarski97.controllers;

import com.kwiniarski97.models.Post;
import com.kwiniarski97.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.JoinColumn;
import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @RequestMapping("/")
    public List<Post> index() {
        return postRepository.findAll();
    }
}
