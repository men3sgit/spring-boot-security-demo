package com.menes.security.controllers;

import com.menes.security.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {
    private final UserService service;
    @GetMapping
    public ResponseEntity<?> getAllUsers(){
        return ResponseEntity.ok(service.getAllUsers());
    }


}
