package com.kwiniarski97.services;

import com.kwiniarski97.models.domain.Post;
import com.kwiniarski97.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    public Page<Post> getLatest(int page, int pageSize) {
        Pageable request = new PageRequest(page, pageSize, Sort.Direction.DESC, "publishDate");
        return repository.findAll(request);
    }

    public void create(Post post) {
        this.repository.save(post);
    }
}
