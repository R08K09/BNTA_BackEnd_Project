package com.example.backend_code.services;

import com.example.backend_code.models.Item;
import com.example.backend_code.models.ItemDTO;
import com.example.backend_code.models.Priority;
import com.example.backend_code.models.ToDoList;
import com.example.backend_code.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        updatedItem.setPriority(itemDTO.getPriority());
        ToDoList toDoList = toDoListService.findListById(itemDTO.getListId());
        updatedItem.setToDoList(toDoList);
        itemRepository.save(updatedItem);
        return updatedItem;
    }


    public List<Item> getItemByPriority(Priority priority) {
        List<Item> allItems = itemRepository.findAll();
        List<Item> filteredItems = new ArrayList<>();
        for (Item items : allItems) {
            if (items.getPriority() == priority) {
                filteredItems.add(items);
            }
        }
        return filteredItems;
    }

    public Item setItemComplete(boolean complete, Long id){
        Item item = itemRepository.findById(id).get();
        item.setCompleted(complete);
        itemRepository.save(item);
        return item;

    }

    public List<Item> getItemByCompletion(Boolean complete){
        List<Item> items = itemRepository.findAll();
        List<Item> filteredItems = new ArrayList<>();
        for (Item item : items) {
            if (item.isCompleted() == complete) {
                filteredItems.add(item);
            }
        }
        return filteredItems;
    }

    public List<Item> getItemByCompletionAndPriority(Priority priority, Boolean complete){
        List<Item> items = itemRepository.findAll();
        List<Item> filteredItems = new ArrayList<>();
        for (Item item : items){
            if(item.isCompleted() == complete) {
                if (item.getPriority() == priority){
                    filteredItems.add(item);
                }
            }
        }
        return filteredItems;
    }

}
