package com.example.bsbstudynovitsky.dto.auth.request;

import lombok.Data;

@Data
public class AuthenticationRequest {

    private String username;
    private String password;

}
