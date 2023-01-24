package com.tweterooapi.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweterooapi.api.dtos.TweetDTO;
import com.tweterooapi.api.models.Tweet;
import com.tweterooapi.api.models.User;
import com.tweterooapi.api.services.TweetsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tweets")
public class TweetsController {

    @Autowired
    private TweetsService service;

    @PostMapping
    public ResponseEntity<Object> createTweet(@RequestBody @Valid TweetDTO tweetDTO) {
        User isUserExists = service.findUserByUsername(tweetDTO);

        if (isUserExists == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found, impossible to create the tweet!");
        } else {
            service.createTweet(tweetDTO, isUserExists);
            return ResponseEntity.status(HttpStatus.CREATED).body("OK");
        }
    }

    @GetMapping
    public ResponseEntity<Object> listTweetsByPagination(
            @PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable page) {
        return ResponseEntity.status(HttpStatus.OK).body(service.listTweetsByPagination(page));
    }

    @GetMapping("/{username}")
    public ResponseEntity<Object> listTweetsByUsername(@PathVariable(value = "username") String username) {
        List<Tweet> findByUsername = service.listTweetsByUsername(username);
        return ResponseEntity.status(HttpStatus.OK).body(findByUsername);
    }
}