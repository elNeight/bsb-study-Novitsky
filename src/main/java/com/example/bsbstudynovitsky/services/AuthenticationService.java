package com.example.bsbstudynovitsky.services;

import com.example.bsbstudynovitsky.dto.auth.request.AuthenticationRequest;
import com.example.bsbstudynovitsky.dto.auth.request.RegistrationRequest;
import com.example.bsbstudynovitsky.dto.auth.response.JwtResponse;
import com.example.bsbstudynovitsky.dto.auth.response.RegistrationResponse;

public interface AuthenticationService {

    JwtResponse authenticate(AuthenticationRequest request);

    RegistrationResponse register(RegistrationRequest request);

}
