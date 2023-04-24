package com.example.backend_code.services;

import com.example.backend_code.models.User;
import com.example.backend_code.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByUserByName(String name) {
        return userRepository.findByName(name);
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public User findUserById(Long id){
        return userRepository.findById(id).get();
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

}