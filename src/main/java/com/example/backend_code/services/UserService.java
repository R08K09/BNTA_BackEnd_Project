package com.example.backend_code.services;

import com.example.backend_code.models.ToDoList;
import com.example.backend_code.models.User;
import com.example.backend_code.models.UserDTO;
import com.example.backend_code.repositories.ToDoListRepository;
import com.example.backend_code.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private ToDoListRepository toDoListRepository;

    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public User findUserById(Long id){
        return userRepository.findById(id).get();
    }

    public User findByUserByName(String name) {
        return userRepository.findByName(name);
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public void removeUserFromToDoList(Long id){
        User foundUser = userRepository.getById(id);
        for (ToDoList toDoList : foundUser.getMasterList()) {
            toDoList.removeUser(foundUser);
        }
    }

    public User updateUser(UserDTO userDTO, Long id){
        User userToUpdate = userRepository.findById(id).get();
        userToUpdate.setName(userDTO.getName());
        userToUpdate.setMasterList(new ArrayList<ToDoList>());
        for (long listIds : userDTO.getListIds()){
            ToDoList toDoList = toDoListRepository.findById(listIds).get();
            userToUpdate.addList(toDoList);
        }
        userRepository.save(userToUpdate);
        return userToUpdate;
    }
}