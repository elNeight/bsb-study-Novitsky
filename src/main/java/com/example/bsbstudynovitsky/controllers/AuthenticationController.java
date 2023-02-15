package com.example.bsbstudynovitsky.controllers;

import com.example.bsbstudynovitsky.dto.auth.request.AuthenticationRequest;
import com.example.bsbstudynovitsky.dto.auth.request.RegistrationRequest;
import com.example.bsbstudynovitsky.dto.auth.response.JwtResponse;
import com.example.bsbstudynovitsky.dto.auth.response.RegistrationResponse;
import com.example.bsbstudynovitsky.services.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/authenticate")
    public ResponseEntity<JwtResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @PostMapping("/register")
    public ResponseEntity<RegistrationResponse> registration(@Valid @RequestBody RegistrationRequest request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

}
