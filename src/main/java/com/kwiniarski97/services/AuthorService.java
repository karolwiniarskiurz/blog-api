package com.kwiniarski97.services;

import com.kwiniarski97.models.domain.Author;
import com.kwiniarski97.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public long create(Author author){
        var obj = this.authorRepository.save(author);
        this.authorRepository.flush();
        return obj.getId();
    }
}
