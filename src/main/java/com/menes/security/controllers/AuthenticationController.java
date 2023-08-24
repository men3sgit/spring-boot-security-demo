package com.menes.security.controllers;

import com.menes.security.requests.AuthenticationRequest;
import com.menes.security.requests.RegisterRequest;
import com.menes.security.responses.AuthenticationResponse;
import com.menes.security.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
  @author Menes
 */
@RestController
@RequestMapping(value = "api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService service;
    @GetMapping
    public ResponseEntity<String> greeting(){
        return ResponseEntity.status(HttpStatus.OK).body("Hello World!!!");
    }

    @PostMapping(value = "/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
            ){
        return ResponseEntity.ok(service.register(request));
    }
    @PostMapping(value = "/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(service.authenticate(request));
    }

}
