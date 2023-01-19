package com.tweterooapi.tweterooapi.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweterooapi.tweterooapi.models.User;

public interface AuthRepository extends JpaRepository<User, Long> {
    
}


