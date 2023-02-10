package com.example.bsbstudynovitsky.services;

import com.example.bsbstudynovitsky.dto.AuthenticationRequest;
import com.example.bsbstudynovitsky.dto.JwtResponse;

public interface AuthenticationService {

    JwtResponse authenticate(AuthenticationRequest request);

}
