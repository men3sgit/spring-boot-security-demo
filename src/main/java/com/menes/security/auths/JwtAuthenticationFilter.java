package com.menes.security.auths;

import com.menes.security.services.JwtService;
import jakarta.security.auth.message.callback.SecretKeyCallback;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private static final String BEARER_KEY = "Bearer ";
    private final JwtService jwtService;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String userEmail;
        if (authHeader == null || !authHeader.startsWith(BEARER_KEY)) {
            filterChain.doFilter(request, response);
            return;
        }
        jwt = authHeader.substring(BEARER_KEY.length());
        userEmail = jwtService.extractUsername(jwt); // todo extract the userEmail from JWT token;

    }

}
