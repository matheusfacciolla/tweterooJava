package com.tweterooapi.tweterooapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweterooapi.tweterooapi.dtos.UserDTO;
import com.tweterooapi.tweterooapi.models.User;
import com.tweterooapi.tweterooapi.repositorys.AuthRepository;

@RestController
@RequestMapping("/")
public class AuthController {

    @Autowired
    private AuthRepository repository;
    
    @PostMapping("/sign-up")
    public ResponseEntity<Object> signUp(@RequestBody UserDTO req) {
        repository.save(new User(req));
        return ResponseEntity.status(HttpStatus.CREATED).body("OK");
    }

    // @GetMapping("/users")
    // public ResponseEntity<Object> listAllUsers(){
    //     return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    // }
}

