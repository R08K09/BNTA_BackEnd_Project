package com.example.backend_code.services;

import com.example.backend_code.models.Item;
import com.example.backend_code.models.ItemDTO;
import com.example.backend_code.models.ToDoList;
import com.example.backend_code.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ToDoListService toDoListService;

    public void createItem(Item item){
        itemRepository.save(item);
    }

    public void deleteItem(Long id){
        itemRepository.deleteById(id);
    }

    public void itemComplete(Long id){
        // find item based on id
        Item item = itemRepository.findById(id).get();

        // replace isComplete
        item.setCompleted(true);

        // save item
        itemRepository.save(item);
    }

    public Item findItemById(Long id){
        return itemRepository.findById(id).get();
    }

    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }

    public void addItemToList(Item item, Long id){
//        Item item = new Item(itemDTO.getTaskName(), itemDTO.getDueDate());
//        itemRepository.findById(id).get();
//
//        ToDoList toDoList
        ToDoList toDoList = toDoListService.findList(id);
        item.setToDoList(toDoList);
        itemRepository.save(item);
    }

}
