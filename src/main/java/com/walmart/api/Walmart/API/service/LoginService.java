package com.walmart.api.Walmart.API.service;

import com.walmart.api.Walmart.API.dto.UserLoginDTO;
import com.walmart.api.Walmart.API.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.walmart.api.Walmart.API.entity.User;

import java.util.Optional;

@Service
public class LoginService {
    private final UserRepository userRepository;

    public LoginService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void login(UserLoginDTO userLoginDTO){
        Optional<User> user = userRepository.findByUsername(userLoginDTO.getUsername());
        System.out.println(user);
    }
}
