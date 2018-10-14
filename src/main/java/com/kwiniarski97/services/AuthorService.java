package com.kwiniarski97.services;

import com.kwiniarski97.exceptions.PasswordDoesntMatchException;
import com.kwiniarski97.models.domain.Author;
import com.kwiniarski97.models.dtos.AuthenticateDTO;
import com.kwiniarski97.models.dtos.AuthenticationDTO;
import com.kwiniarski97.models.dtos.AuthorCreateDTO;
import com.kwiniarski97.models.dtos.AuthorDTO;
import com.kwiniarski97.repository.AuthorRepository;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthService authService;

    @Autowired
    private Mapper mapper;

    public long create(AuthorCreateDTO authorDTO) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        var author = mapper.map(authorDTO, Author.class);
        setPassword(authorDTO.password, author);
        var obj = this.authorRepository.save(author);
        this.authorRepository.flush();
        return obj.getId();
    }

    private void setPassword(String password, Author author) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        var salt = UUID.randomUUID().toString();
        var passwordHash = authService.getPasswordHash(password, salt);
        author.setPasswordSalt(salt);
        author.setPasswordHash(passwordHash);
    }

    public AuthenticationDTO authenticate(AuthenticateDTO auth) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, PasswordDoesntMatchException {
        var author = authorRepository.getAuthorByNickName(auth.nickName);
        if (author == null) {
            throw new EntityNotFoundException();
        }
        var passwordHash = authService.getPasswordHash(auth.password, author.getPasswordSalt());
        if (!passwordHash.equals(author.getPasswordHash())) {
            throw new PasswordDoesntMatchException();
        }
        return null;
    }

    public AuthorDTO getById(long id) {
        var author = authorRepository.findOne(id);
        return mapper.map(author, AuthorDTO.class);
    }
}
