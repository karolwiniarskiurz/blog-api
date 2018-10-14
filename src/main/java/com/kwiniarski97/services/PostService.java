package com.kwiniarski97.services;

import com.kwiniarski97.models.domain.Post;
import com.kwiniarski97.models.dtos.PostCreateDTO;
import com.kwiniarski97.models.dtos.PostDetailDTO;
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
    public Page<PostRecentDTO> getLatest(int page) {
        Pageable request = new PageRequest(page - 1, PAGE_SIZE, Sort.Direction.DESC, "publishDate");
        var entities = repository.findByPublishDateIsNotNullAndDeletedIsFalse(request);
        return entities.map(entity -> {
            var dest = new PostRecentDTO();
            mapper.map(entity, dest);
            return dest;
        });
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

    public void delete(long id) {
        var post = repository.findOne(id);
        post.setDeleted(true);
        this.repository.flush();
    }


    private Timestamp getCurrentTimeStamp() {
        return new Timestamp(new Date().getTime());
    }

    public void update(long id, PostCreateDTO createDTO) {
        var post = repository.findOne(id);
        mapper.map(createDTO, post);
        repository.flush();
    }

    public PostDetailDTO getById(long id) {
        var post = repository.findOne(id);
        return mapper.map(post, PostDetailDTO.class);
    }
}
