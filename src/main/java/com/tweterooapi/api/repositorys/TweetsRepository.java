package com.tweterooapi.api.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweterooapi.api.models.Tweet;

public interface TweetsRepository extends JpaRepository<Tweet, Long> {
}