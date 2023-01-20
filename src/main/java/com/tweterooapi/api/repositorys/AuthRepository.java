package com.tweterooapi.api.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweterooapi.api.models.User;

public interface AuthRepository extends JpaRepository<User, Long> {    
}


