package com.example.bsbstudynovitsky.services;

import com.example.bsbstudynovitsky.dto.auth.AuthenticationRequest;
import com.example.bsbstudynovitsky.dto.auth.JwtResponse;

public interface AuthenticationService {

    JwtResponse authenticate(AuthenticationRequest request);

}
