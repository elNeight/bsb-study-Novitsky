package com.example.bsbstudynovitsky.controllers;

import com.example.bsbstudynovitsky.dto.AuthenticationRequest;
import com.example.bsbstudynovitsky.security.jwt.provider.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest request) {

        String username = request.getUsername();
        String password = request.getPassword();

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        username,
                        password
                )
        );

        UserDetails details = (UserDetails) authentication.getPrincipal();

        if (Objects.isNull(details))
            return ResponseEntity.status(400).body("ERROR SOMETHING IS WRONG");

        String token = jwtService.generateToken(details);

        return ResponseEntity.ok(Map.of("username", details.getUsername(), "token", token));
    }

}
