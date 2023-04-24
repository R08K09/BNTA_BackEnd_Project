package com.example.backend_code.services;

import com.example.backend_code.models.Item;
import com.example.backend_code.models.ItemDTO;
import com.example.backend_code.models.ToDoList;
import com.example.backend_code.repositories.ItemRepository;
import com.example.backend_code.repositories.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoListService {

    @Autowired
    ToDoListRepository toDoListRepository;

    @Autowired
    ItemRepository itemRepository;

    public void createList(ToDoList toDoList){
        toDoListRepository.save(toDoList);
    }

    public void deleteList(Long id){
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

    public void addItemToList(ItemDTO itemDTO, Long id){
        Item item = new Item(itemDTO.getTaskName(), itemDTO.getDueDate());
        itemRepository.findById(id).get();
    }
}
