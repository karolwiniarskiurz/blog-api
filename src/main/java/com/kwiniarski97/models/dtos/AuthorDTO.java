package com.kwiniarski97.models.dtos;

import lombok.Getter;
import lombok.Setter;

public class AuthorDTO {
    @Getter
    @Setter
    public String firstName;
    @Getter
    @Setter
    public String lastName;
    @Getter
    @Setter
    public String nickName;
    @Getter
    @Setter
    public String email;
    @Getter
    @Setter
    public String avatarPath;
    @Getter
    @Setter
    public String description;
}
