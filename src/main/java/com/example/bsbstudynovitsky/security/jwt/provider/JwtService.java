package com.example.bsbstudynovitsky.security.jwt.provider;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.function.Function;

public interface JwtService {

    String generateToken(UserDetails userDetails);

    <T> T extractClaim(String token, Function<Claims, T> resolver);

    boolean isTokenValid(String token, UserDetails userDetails);

}
