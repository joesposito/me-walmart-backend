package com.walmart.api.Walmart.API.service;

import com.walmart.api.Walmart.API.entity.User;
import com.walmart.api.Walmart.API.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public void createUser(User user){
        userRepository.save(user);
    }

    public Optional<User> getUser(UUID user_id){
        Optional<User> user = userRepository.findByUserId(user_id);
        return user;
    }
}
