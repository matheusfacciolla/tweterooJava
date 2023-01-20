package com.tweterooapi.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweterooapi.api.dtos.UserDTO;
import com.tweterooapi.api.models.User;
import com.tweterooapi.api.repositorys.AuthRepository;

@Service
public class AuthService {

    @Autowired
    private AuthRepository repository;

    public void signUp(UserDTO userDTO) {
        repository.save(new User(userDTO));
    }
}
