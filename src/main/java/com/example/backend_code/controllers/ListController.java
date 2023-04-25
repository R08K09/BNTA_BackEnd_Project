package com.example.backend_code.controllers;
import com.example.backend_code.models.ListDTO;
import com.example.backend_code.models.ToDoList;
import com.example.backend_code.models.User;
import com.example.backend_code.models.UserDTO;
import com.example.backend_code.services.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/lists")
public class ListController {

    @Autowired
    ToDoListService toDoListService;

    // INDEX
    @GetMapping
    public ResponseEntity<List<ToDoList>> showAllToDoLists(){
        return  new ResponseEntity<>(toDoListService.findAllLists(), HttpStatus.OK);
    }

    // SHOW
    @GetMapping(value = "/{id}")
    public ResponseEntity<ToDoList> getListById(@PathVariable Long id){
        return new ResponseEntity<>(toDoListService.findListById(id), HttpStatus.OK);
    }

    // CREATE
    @PostMapping
    public ResponseEntity<List<ToDoList>> createList(@RequestBody ListDTO listDTO){
        toDoListService.createList(listDTO);
        return new ResponseEntity<>(toDoListService.findAllLists(), HttpStatus.CREATED);
    }

    // DELETE
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteList(@PathVariable Long id){
        toDoListService.deleteList(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    // UPDATE
    @PutMapping(value = "/{id}")
    public ResponseEntity<ToDoList> updateToDoList(@RequestBody ListDTO listDTO, @PathVariable Long id){
        ToDoList updatedToDoList = toDoListService.updateToDoList(listDTO, id);
        return new ResponseEntity<>(updatedToDoList, HttpStatus.OK);
    }



}
