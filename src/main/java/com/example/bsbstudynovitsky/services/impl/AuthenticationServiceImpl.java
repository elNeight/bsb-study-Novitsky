package com.example.bsbstudynovitsky.services.impl;

import com.example.bsbstudynovitsky.dto.AuthenticationRequest;
import com.example.bsbstudynovitsky.dto.JwtResponse;
import com.example.bsbstudynovitsky.security.jwt.provider.JwtService;
import com.example.bsbstudynovitsky.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Objects;

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

        if (Objects.isNull(details))
            throw new BadCredentialsException("Bad credentials");

        JwtResponse jwtResponse = new JwtResponse();
        jwtResponse.setToken(jwtService.generateToken(details));

        return jwtResponse;
    }

}
