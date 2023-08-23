package com.menes.security.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
  @author Menes
 
 */
@RestController
@RequestMapping(value = {"home", "/", ""})

public class Controller {
    @GetMapping
    public ResponseEntity<String> greeting(){
        return ResponseEntity.status(HttpStatus.OK).body("Hello World!!!");
    }

}
