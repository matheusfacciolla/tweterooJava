package com.tweterooapi.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweterooapi.api.dtos.UserDTO;
import com.tweterooapi.api.models.User;
import com.tweterooapi.api.repositories.AuthRepository;

@Service
public class AuthService {

    @Autowired
    private AuthRepository authRepository;

    public User findUserByUsername(UserDTO userDTO) {
        return authRepository.findByUsername(userDTO.username());
    }

    public void signUp(UserDTO userDTO) {
        authRepository.save(new User(userDTO));
    }
}
