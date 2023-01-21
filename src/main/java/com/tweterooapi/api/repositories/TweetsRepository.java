package com.tweterooapi.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweterooapi.api.models.Tweet;

public interface TweetsRepository extends JpaRepository<Tweet, Long> {
}