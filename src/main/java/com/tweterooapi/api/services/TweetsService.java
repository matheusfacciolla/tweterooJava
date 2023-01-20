package com.tweterooapi.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweterooapi.api.dtos.TweetDTO;
import com.tweterooapi.api.models.Tweet;
import com.tweterooapi.api.repositorys.TweetsRepository;

@Service
public class TweetsService {
    
    @Autowired
    private TweetsRepository repository;

    public void createTweet(TweetDTO tweetDTO) {
        repository.save(new Tweet(tweetDTO));
    }
}
