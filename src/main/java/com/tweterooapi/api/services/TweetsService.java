package com.tweterooapi.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tweterooapi.api.dtos.TweetDTO;
import com.tweterooapi.api.models.Tweet;
import com.tweterooapi.api.repositories.TweetsRepository;

@Service
public class TweetsService {
    
    @Autowired
    private TweetsRepository repository;

    public void createTweet(TweetDTO tweetDTO) {
        repository.save(new Tweet(tweetDTO));
    }

    public Page<Tweet> listTweetsByPagination(Pageable page) {
        return repository.findAll(page);
    }
}
