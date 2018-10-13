package com.kwiniarski97.repository;

import com.kwiniarski97.models.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    // great job creating query by name best idea ever 😖
    Page<Post> findByPublishDateIsNotNull(Pageable pageable);

    Page<Post> findByAuthorId(long authorId, Pageable pageable);
}
