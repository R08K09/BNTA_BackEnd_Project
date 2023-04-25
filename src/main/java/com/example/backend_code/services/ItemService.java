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
        ToDoList toDoList = toDoListService.findListById(id);
        item.setToDoList(toDoList);
        itemRepository.save(item);
    }

    public Item updateItem(ItemDTO itemDTO, Long id) {
        Item updatedItem = itemRepository.findById(id).get();
        updatedItem.setTaskName(itemDTO.getTaskName());
        updatedItem.setDueDate(itemDTO.getDueDate());
        ToDoList toDoList = toDoListService.findListById(itemDTO.getListId());
        updatedItem.setToDoList(toDoList);
        itemRepository.save(updatedItem);
        return updatedItem;
    }

}
