package com.sistema.api.model;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String email;
    private String password;
}
