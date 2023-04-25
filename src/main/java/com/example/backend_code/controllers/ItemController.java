package com.example.backend_code.controllers;


import com.example.backend_code.models.Item;
import com.example.backend_code.models.ItemDTO;
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
    public ResponseEntity<List<Item>> getAllItems() {
        return new ResponseEntity(itemService.getAllItems(), HttpStatus.OK);
    }

    // SHOW
    @GetMapping (value = "/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        return new ResponseEntity<>(itemService.findItemById(id), HttpStatus.OK);
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Item> postItem(@RequestBody Item item) {
        itemService.createItem(item);
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    // DELETE
    @DeleteMapping (value = "/{id}")
    public ResponseEntity<Long> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    // UPDATE
    @PutMapping(value = "/{id}")
    public ResponseEntity<Item> updateItem(@RequestBody ItemDTO itemDTO, @PathVariable Long id){
        Item item = itemService.updateItem(itemDTO, id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }








}
