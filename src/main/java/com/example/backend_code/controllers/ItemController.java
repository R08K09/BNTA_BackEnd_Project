package com.example.backend_code.controllers;


import com.example.backend_code.models.Item;
import com.example.backend_code.models.ItemDTO;
import com.example.backend_code.models.Priority;
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

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems(@RequestParam(name="priority") Priority priority) {
        if(priority != null){
            return new ResponseEntity<>(itemService.getItemByPriority(priority), HttpStatus.OK);
        }
        return new ResponseEntity(itemService.getAllItems(), HttpStatus.OK);
    }

    @GetMapping (value = "/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        return new ResponseEntity<>(itemService.findItemById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Item> postItem(@RequestBody Item item) {
        itemService.createItem(item);
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    @DeleteMapping (value = "/{id}")
    public ResponseEntity<Long> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Item> updateItem(@RequestBody ItemDTO itemDTO, @PathVariable Long id){
        Item item = itemService.updateItem(itemDTO, id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }



//    filtering request based on property(priority)
//    this will be a get request
//    @GetMapping(value = "/priority")
//    public ResponseEntity<List<Item>> getItemByPriority(@RequestParam Priority priority,
//                                                        @PathVariable Long id){
////        List<Item> items = itemService.getItemByPriority(priority);
//        return new ResponseEntity<>(items, HttpStatus.OK);
//    }







}
