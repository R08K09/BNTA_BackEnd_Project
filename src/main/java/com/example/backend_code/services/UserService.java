package com.example.backend_code.services;

import com.example.backend_code.models.Item;
import com.example.backend_code.models.ToDoList;
import com.example.backend_code.models.User;
import com.example.backend_code.models.UserDTO;
import com.example.backend_code.repositories.ItemRepository;
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

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    ToDoListService toDoListService;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id).get();
    }

    public User getByUserByName(String name) {
        return userRepository.findByName(name);
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        User user = userRepository.findById(id).get();
        ArrayList<Long> idsToDelete = new ArrayList<>();
        for(ToDoList toDoList : user.getMasterList()){
            if (toDoList.getUsers().size() == 1){
                idsToDelete.add(toDoList.getId());
            }
        }
        for(Long toDoListId : idsToDelete){
            toDoListService.deleteList(toDoListId);
        }
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
        if (userDTO.getName() != null) {
            userToUpdate.setName(userDTO.getName());
        }
        if (userDTO.getListIds() != null) {
            userToUpdate.setMasterList(new ArrayList<ToDoList>());
            for (long listIds : userDTO.getListIds()) {
                ToDoList toDoList = toDoListRepository.findById(listIds).get();
                userToUpdate.addList(toDoList);
            }
        }
        userRepository.save(userToUpdate);
        return userToUpdate;
    }
}