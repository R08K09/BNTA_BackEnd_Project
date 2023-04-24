package com.example.backend_code.services;

import com.example.backend_code.models.User;
import com.example.backend_code.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByUser(String name) {
        return userRepository.findByName(name);
    }



}