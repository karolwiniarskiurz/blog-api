package com.kwiniarski97.models.dtos;

import lombok.Getter;
import lombok.Setter;

public class AuthorDTO {
    @Getter
    @Setter
    private String firstName;
    @Getter
    @Setter
    private String lastName;
    @Getter
    @Setter
    private String nickName;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String avatarPath;
    @Getter
    @Setter
    private String description;
}
