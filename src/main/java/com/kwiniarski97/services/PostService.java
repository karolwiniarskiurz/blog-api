package com.kwiniarski97.services;

import com.kwiniarski97.models.domain.Post;
import com.kwiniarski97.models.dtos.PostCreateDTO;
import com.kwiniarski97.models.dtos.PostRecentDTO;
import com.kwiniarski97.repository.PostRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class PostService {

    private final int PAGE_SIZE = 10;

    @Autowired
    private PostRepository repository;

    @Autowired
    DozerBeanMapper mapper;

    /**
     * @param page 1 - indexed
     */
    public Page<Post> getLatest(int page) {
        Pageable request = new PageRequest(page - 1, PAGE_SIZE, Sort.Direction.DESC, "publishDate");
        var list = repository.findByPublishDateIsNotNullAndDeletedIsFalse(request);
        list.map(post -> mapper.map(post, PostRecentDTO.class));
        return list;
    }

    public long create(PostCreateDTO postCreate) {
        var post = mapper.map(postCreate, Post.class);
        post.setCreationDate(getCurrentTimeStamp());
        var obj = this.repository.save(post);
        this.repository.flush();
        return obj.getId();
    }

    public void publish(long id) {
        var post = repository.findOne(id);
        post.setPublishDate(getCurrentTimeStamp());
        this.repository.flush();
    }

    public void delete(long id){
        var post = repository.findOne(id);
        post.setDeleted(true);
        this.repository.flush();
    }


    private Timestamp getCurrentTimeStamp() {
        return new Timestamp(new Date().getTime());
    }
}
