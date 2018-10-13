package com.kwiniarski97.repository;

import com.kwiniarski97.models.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
