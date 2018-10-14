package com.kwiniarski97.models.dtos;

import lombok.Getter;
import lombok.Setter;

public class AuthenticateDTO {
    @Getter
    @Setter
    public String nickName;
    @Getter
    @Setter
    public String password;
}
