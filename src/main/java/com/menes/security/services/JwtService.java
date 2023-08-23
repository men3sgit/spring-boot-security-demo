package com.menes.security.services;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;
import java.util.function.Function;

public  interface JwtService {

    String extractUsername(String token);

    boolean isValidToken(String token, UserDetails userDetails);

    String generateToken(Map<String, Object> extractClaims,
                         UserDetails userDetails);

    String generateToken(UserDetails userDetails);

    <T> T extractClaims(String token, Function<Claims, T> claimResolver);
}
