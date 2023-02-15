package com.example.bsbstudynovitsky.services.impl;

import com.example.bsbstudynovitsky.dto.auth.request.AuthenticationRequest;
import com.example.bsbstudynovitsky.dto.auth.request.RegistrationRequest;
import com.example.bsbstudynovitsky.dto.auth.response.JwtResponse;
import com.example.bsbstudynovitsky.dto.auth.response.RegistrationResponse;
import com.example.bsbstudynovitsky.entities.security.Role;
import com.example.bsbstudynovitsky.entities.security.UserAuthDetails;
import com.example.bsbstudynovitsky.repositories.UserAuthDetailsRepository;
import com.example.bsbstudynovitsky.security.jwt.provider.JwtService;
import com.example.bsbstudynovitsky.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final UserAuthDetailsRepository userAuthDetailsRepository;
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

        Optional<UserAuthDetails> optionalUser = userAuthDetailsRepository.findByUsername(request.getUsername());

        if (optionalUser.isPresent())
            return new RegistrationResponse("Username already exists");

        UserAuthDetails user = new UserAuthDetails();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);

        userAuthDetailsRepository.save(user);

        return new RegistrationResponse("Success");

    }

}
