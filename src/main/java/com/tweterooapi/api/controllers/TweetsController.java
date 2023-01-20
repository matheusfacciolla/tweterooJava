package com.tweterooapi.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweterooapi.api.dtos.TweetDTO;
import com.tweterooapi.api.services.TweetsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tweets")
public class TweetsController {

    @Autowired
    private TweetsService service;

    @PostMapping
    public ResponseEntity<Object> createTweet(@RequestBody @Valid TweetDTO tweetDTO) {
        service.createTweet(tweetDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("OK");
    }
}