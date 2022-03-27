package com.mock.flight.security.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Login {
    private String userName;
    private String password;

    public Login(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
