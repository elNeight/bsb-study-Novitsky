package com.example.bsbstudynovitsky.dto.auth.request;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class RegistrationRequest {

    @Pattern(regexp = "^[a-z0-9_-]{3,16}$",
            message = "Username must contain digits or characters (3-16 chars)")
    private String username;
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[a-z]).{8,20}$",
            message = "Password must have digits, upper and lower case characters (8-20 chars)")
    private String password;

}
