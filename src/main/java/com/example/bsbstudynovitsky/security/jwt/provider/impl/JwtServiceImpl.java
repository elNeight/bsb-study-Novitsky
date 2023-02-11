package com.example.bsbstudynovitsky.security.jwt.provider.impl;

import com.example.bsbstudynovitsky.security.jwt.provider.JwtService;
import io.jsonwebtoken.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.function.Function;

@Slf4j
public class JwtServiceImpl implements JwtService {

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private long expiration;
    @Value("${jwt.header}")
    private String authorizationHeaderName;

    @Override
    public String generateToken(UserDetails userDetails) {

        Instant now = Instant.now();

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(expiration, ChronoUnit.MINUTES)))
                .claim("role", userDetails.getAuthorities())
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    @Override
    public <T> T extractClaim(String token, Function<Claims, T> claimExtractor) {

        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();

        return claimExtractor.apply(claims);
    }

    @Override
    public boolean isTokenValid(String token) {

        try {
            extractClaim(token, Function.identity());
            return true;
        } catch (ExpiredJwtException expEx) {
            log.error("Token expired");
        } catch (UnsupportedJwtException unsEx) {
            log.error("Unsupported jwt");
        } catch (MalformedJwtException mjEx) {
            log.error("Malformed jwt");
        } catch (SignatureException sEx) {
            log.error("Invalid signature");
        } catch (Exception e) {
            log.error("invalid token");
        }

        return false;
    }

    public String getTokenFromRequest(HttpServletRequest request) {
        return request.getHeader(authorizationHeaderName);
    }

}
