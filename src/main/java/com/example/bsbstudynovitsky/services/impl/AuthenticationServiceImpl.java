package com.example.bsbstudynovitsky.services.impl;

import com.example.bsbstudynovitsky.dto.auth.AuthenticationRequest;
import com.example.bsbstudynovitsky.dto.auth.JwtResponse;
import com.example.bsbstudynovitsky.security.jwt.provider.JwtService;
import com.example.bsbstudynovitsky.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public JwtResponse authenticate(AuthenticationRequest request) {

        String username = request.getUsername();
        String password = request.getPassword();

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        username,
                        password
                )
        );

        UserDetails details = (UserDetails) authentication.getPrincipal();

        JwtResponse jwtResponse = new JwtResponse();
        jwtResponse.setToken(jwtService.generateToken(details));

        return jwtResponse;
    }

}
