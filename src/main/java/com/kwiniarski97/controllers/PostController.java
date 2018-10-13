package com.kwiniarski97.controllers;

import com.kwiniarski97.models.domain.Post;
import com.kwiniarski97.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final int PAGE_SIZE = 10;

    @Autowired
    private PostService postService;

    @RequestMapping("/recent/{page}")
    public Page<Post> getRecent(@PathVariable(value="page")int page) {
        return postService.getLatest(page, PAGE_SIZE);
    }

    @PostMapping("/create")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void create(@RequestBody Post post){
        postService.create(post);
    }
}
