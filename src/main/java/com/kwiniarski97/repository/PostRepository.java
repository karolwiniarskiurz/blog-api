package com.kwiniarski97.repository;

import com.kwiniarski97.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
