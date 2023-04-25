package com.example.backend_code.services;

import com.example.backend_code.models.*;
import com.example.backend_code.repositories.ItemRepository;
import com.example.backend_code.repositories.ToDoListRepository;
import com.example.backend_code.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ToDoListService {

    @Autowired
    ToDoListRepository toDoListRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    UserRepository userRepository;

    public void createList(ListDTO listDTO){
//        toDoListRepository.save(toDoList);
        ToDoList toDoList1 = new ToDoList(listDTO.getListName());

        for (Long userId : listDTO.getUserIds()){
            User user = userRepository.findById(userId).get();
            toDoList1.addUser(user);
        }
        for (Long itemId : listDTO.getItemIds()){
            Item item = itemRepository.findById(itemId).get();
            toDoList1.addItem(item);
        }
        toDoListRepository.save(toDoList1);
    }

    public ToDoList updateToDoList(ListDTO listDTO, Long id){
        ToDoList listToUpdate = toDoListRepository.findById(id).get();
        listToUpdate.setListName(listDTO.getListName());
        listToUpdate.setUsers(new ArrayList<User>());
        listToUpdate.setItems(new ArrayList<Item>());
        for (Long userId : listDTO.getUserIds()){
            User user = userRepository.findById(userId).get();
            listToUpdate.addUser(user);
        }
        for (Long itemId : listDTO.getItemIds()){
            Item item = itemRepository.findById(itemId).get();
            listToUpdate.addItem(item);
        }
        toDoListRepository.save(listToUpdate);
        return listToUpdate;
    }

    public void deleteList(Long id){
        ToDoList toDoList = toDoListRepository.findById(id).get();
        for(Item item : toDoList.getItems()){
            itemRepository.delete(item);
        }
        toDoListRepository.deleteById(id);
    }

    public void listComplete(Long id){
        // find item based on id
        ToDoList toDoList = toDoListRepository.findById(id).get();

        // replace isComplete
        toDoList.setIsCompleted(true);

        // save item
        toDoListRepository.save(toDoList);
    }

    public ToDoList findListById(Long id){
        return toDoListRepository.findById(id).get();
    }

    public List<ToDoList> findAllLists(){
        return toDoListRepository.findAll();
    }

    public ToDoList setListComplete(Long id){
        ToDoList toDoList = toDoListRepository.findById(id).get();
        toDoList.setIsCompleted(true);
        toDoListRepository.save(toDoList);
        for (Item item : toDoList.getItems()){
            item.setCompleted(true);
            itemRepository.save(item);
        }
        return toDoList;
    }


}
