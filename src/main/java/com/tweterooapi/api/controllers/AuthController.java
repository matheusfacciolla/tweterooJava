package com.tweterooapi.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweterooapi.api.dtos.UserDTO;
import com.tweterooapi.api.models.User;
import com.tweterooapi.api.services.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/sign-up")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping
    public ResponseEntity<Object> signUp(@RequestBody @Valid UserDTO userDTO) {
        User isUserExists = service.findUserByUsername(userDTO);

        if (isUserExists == null) {
            service.signUp(userDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("OK");
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("This username is already exists!");
        }
    }
}