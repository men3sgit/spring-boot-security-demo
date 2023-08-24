package com.menes.security.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/greeting")


public class HomeController {

    @GetMapping
    public ResponseEntity<String> getting(){
        return ResponseEntity.ok("Hello every body, welcome to my github!");
    }
}
