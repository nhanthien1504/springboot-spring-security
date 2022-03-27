package com.mock.flight.security.dto;

import com.mock.flight.entities.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class Register {

    private String userName;
    private String email;
    private String password;
    private Set<Role> roles;
}
