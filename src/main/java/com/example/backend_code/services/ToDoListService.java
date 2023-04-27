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

    public List<ToDoList> getAllLists(){
        return toDoListRepository.findAll();
    }

    public ToDoList getListById(Long id){
        return toDoListRepository.findById(id).get();
    }

    public void createList(ListDTO listDTO){
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

    public ToDoList updateToDoList(ToDoList toDoList, Long id){
        ToDoList listToUpdate = toDoListRepository.findById(id).get();
        listToUpdate.setListName(toDoList.getListName());
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

    public ToDoList setListComplete(boolean complete, Long id){
        ToDoList toDoList = toDoListRepository.findById(id).get();
        toDoList.setIsCompleted(complete);
        toDoListRepository.save(toDoList);
        for (Item item : toDoList.getItems()){
            item.setCompleted(complete);
            itemRepository.save(item);
        }
        return toDoList;
    }

    public List<ToDoList> getListByCompletion(Boolean complete){
        List<ToDoList> lists = toDoListRepository.findAll();
        List<ToDoList> filteredLists = new ArrayList<>();
        for (ToDoList toDoList : lists) {
            if (toDoList.getIsCompleted() == complete) {
                filteredLists.add(toDoList);
            }
        }
        return filteredLists;
    }
}
