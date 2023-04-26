package com.example.backend_code.services;

import com.example.backend_code.models.Item;
import com.example.backend_code.models.ItemDTO;
import com.example.backend_code.models.Priority;
import com.example.backend_code.models.ToDoList;
import com.example.backend_code.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ToDoListService toDoListService;

    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }

    public Item getItemById(Long id) {
        return itemRepository.findById(id).get();
    }

    public void createItem(Item item){
        itemRepository.save(item);
    }

    public void deleteItem(Long id){
        itemRepository.deleteById(id);
    }

    public Item updateItem(ItemDTO itemDTO, Long id) {
        Item updatedItem = itemRepository.findById(id).get();
        updatedItem.setTaskName(itemDTO.getTaskName());
        updatedItem.setDueDate(itemDTO.getDueDate());
        updatedItem.setPriority(itemDTO.getPriority());
        ToDoList toDoList = toDoListService.getListById(itemDTO.getListId());
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

    @Scheduled(cron = "0 0 8 1/1 * *", zone = "Europe/London")
    public void checkDueDates(){
        LocalDate currentDate = LocalDate.now();
        for(Item item : itemRepository.findAll()) {
            if (item.getDueDate().equals(currentDate)) {
                System.out.println("Tasks due for today: " + item.getTaskName());
            }
        }
    }

}
