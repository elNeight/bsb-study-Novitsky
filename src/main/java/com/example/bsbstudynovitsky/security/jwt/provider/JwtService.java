package com.example.bsbstudynovitsky.security.jwt.provider;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.function.Function;

public interface JwtService {

    String generateToken(UserDetails userDetails);

    <T> T extractClaim(String token, Function<? super Claims, T> resolver);

    boolean isTokenValid(String token);

    String getTokenFromRequest(HttpServletRequest request);

}
