package com.menes.security.controllers;

import com.menes.security.exceptions.ApiRequestException;
import com.menes.security.requests.AuthenticationRequest;
import com.menes.security.requests.RegisterRequest;
import com.menes.security.responses.AuthenticationResponse;
import com.menes.security.services.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author Menes
 */
@RestController
@RequestMapping(value = "api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService service;

    @PostMapping(value = "/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return new ResponseEntity<>(service.register(request), HttpStatus.CREATED);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestHeader(HttpHeaders.AUTHORIZATION) String bearerToken) {
        String token = bearerToken.split(" ")[1];
        return ResponseEntity.ok(service.logout(token));
    }

    @PostMapping(value = "")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest login, HttpServletRequest request) {
        System.out.println(getClientIP(request));
        return ResponseEntity.ok(service.authenticate(login));
    }

    private String getClientIP(HttpServletRequest request) {
        String[] headerNames = {"X-Forwarded-For", "Proxy-Client-IP", "WL-Proxy-Client-IP"};

        return Arrays.stream(headerNames)
                .map(request::getHeader)
                .filter(Objects::nonNull)
                .filter(ipAddress -> !ipAddress.isEmpty() && !"unknown".equalsIgnoreCase(ipAddress))
                .findFirst()
                .orElse(request.getRemoteAddr());
    }


}
