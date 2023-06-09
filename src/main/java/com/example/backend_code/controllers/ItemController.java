package com.example.backend_code.controllers;


import com.example.backend_code.models.Item;
import com.example.backend_code.models.ItemDTO;

import com.example.backend_code.models.Priority;

import com.example.backend_code.models.ToDoList;

import com.example.backend_code.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("items")
public class ItemController {

    @Autowired
    ItemService itemService;

    // INDEX
    @GetMapping
    public ResponseEntity<List<Item>> getAllItemsAndFilters(@RequestParam(required=false, name="priority") Priority priority,
                                                  @RequestParam(required = false, name = "completed") Boolean complete) {
        if(priority != null && complete != null){
            return new ResponseEntity<>(itemService.getItemByCompletionAndPriority(priority, complete), HttpStatus.OK);
        }
        if(priority != null){
            return new ResponseEntity<>(itemService.getItemByPriority(priority), HttpStatus.OK);
        }
        if(complete != null){
            return new ResponseEntity<>(itemService.getItemByCompletion(complete), HttpStatus.OK);
        }
        return new ResponseEntity<>(itemService.getAllItems(), HttpStatus.OK);
    }

    // SHOW
    @GetMapping (value = "/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        return new ResponseEntity<>(itemService.getItemById(id), HttpStatus.OK);
    }

    // CREATE
    @PostMapping
    public ResponseEntity<ItemDTO> postItem(@RequestBody ItemDTO itemDTO) {
        itemService.createItem(itemDTO);
        return new ResponseEntity<>(itemDTO, HttpStatus.CREATED);
    }

    // UPDATE
    @PatchMapping(value = "/update/{id}")
    public ResponseEntity<Item> updateItem(@RequestBody ItemDTO itemDTO, @PathVariable Long id){
        Item item = itemService.updateItem(itemDTO, id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @PatchMapping(value="/{id}")
    public ResponseEntity<Item> setItemComplete(@RequestParam(name="completed") Boolean completed, @PathVariable Long id){
        Item completedItem = itemService.setItemComplete(completed, id);
        return new ResponseEntity<>(completedItem, HttpStatus.OK);
    }

    // DELETE
    @DeleteMapping (value = "/{id}")
    public ResponseEntity<Long> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }


}
