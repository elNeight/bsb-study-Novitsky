package com.example.bsbstudynovitsky.services.impl;

import com.example.bsbstudynovitsky.dto.auth.request.AuthenticationRequest;
import com.example.bsbstudynovitsky.dto.auth.request.RegistrationRequest;
import com.example.bsbstudynovitsky.dto.auth.response.JwtResponse;
import com.example.bsbstudynovitsky.dto.auth.response.RegistrationResponse;
import com.example.bsbstudynovitsky.security.jwt.provider.JwtService;
import com.example.bsbstudynovitsky.security.user.UserAuthDetails;
import com.example.bsbstudynovitsky.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final JwtService jwtService;
    private final UserDetailsManager userDetailsManager;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtResponse authenticate(AuthenticationRequest request) {

        Authentication authentication = authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken.unauthenticated(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails details = (UserDetails) authentication.getPrincipal();

        JwtResponse jwtResponse = new JwtResponse();
        jwtResponse.setToken(jwtService.generateToken(details));

        return jwtResponse;
    }

    @Override
    public RegistrationResponse register(RegistrationRequest request) {

        if (userDetailsManager.userExists(request.getUsername()))
            return new RegistrationResponse("User already exists");

        userDetailsManager.createUser(
                UserAuthDetails.builder()
                        .username(request.getUsername())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .authorities(Collections.singleton(new SimpleGrantedAuthority("USER")))
                        .build()
        );

        return new RegistrationResponse("Success");
    }

}
