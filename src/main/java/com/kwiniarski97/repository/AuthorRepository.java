package com.kwiniarski97.repository;

import com.kwiniarski97.models.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author getAuthorByNickName(String nickName);
}
