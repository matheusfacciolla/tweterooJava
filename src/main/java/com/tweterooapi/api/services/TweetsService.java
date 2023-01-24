package com.tweterooapi.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tweterooapi.api.dtos.TweetDTO;
import com.tweterooapi.api.models.Tweet;
import com.tweterooapi.api.models.User;
import com.tweterooapi.api.repositories.AuthRepository;
import com.tweterooapi.api.repositories.TweetsRepository;

@Service
public class TweetsService {

    @Autowired
    private TweetsRepository tweetsRepository;

    @Autowired
    private AuthRepository authRepository;

    public User findUserByUsername(TweetDTO tweetDTO) {
        return authRepository.findByUsername(tweetDTO.username());
    }

    public void createTweet(TweetDTO tweetDTO, User user) {
        tweetsRepository.save(new Tweet(tweetDTO, user));
    }

    public Page<Tweet> listTweetsByPagination(Pageable page) {
        return tweetsRepository.findAll(page);
    }

    public List<Tweet> listTweetsByUsername(String username) {
        return tweetsRepository.findByUsername(username);
    }
}
