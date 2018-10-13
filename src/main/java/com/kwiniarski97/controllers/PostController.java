package com.kwiniarski97.controllers;

import com.kwiniarski97.models.domain.Post;
import com.kwiniarski97.models.dtos.PostCreateDTO;
import com.kwiniarski97.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {


    @Autowired
    private PostService postService;

    @RequestMapping("/recent/{page}")
    public Page<Post> getRecent(@PathVariable(value="page")int page) {
        return postService.getLatest(page);
    }

    @PostMapping("/create")
    @ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public long create(@RequestBody PostCreateDTO post){
        return postService.create(post);
    }

    @PutMapping("/publish/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void publish(@PathVariable(value = "id") long id){
        postService.publish(id);
    }
}
