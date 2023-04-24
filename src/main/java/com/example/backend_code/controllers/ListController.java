package com.example.backend_code.controllers;


import com.example.backend_code.models.ToDoList;
import com.example.backend_code.services.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/lists")
public class ListController {

    @Autowired
    ToDoListService toDoListService;

    @GetMapping
    public ResponseEntity<List<ToDoList>> showAllToDoLists(){
        return  new ResponseEntity<>(toDoListService.findAllLists(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ToDoList> getListById(@PathVariable Long id){
        return new ResponseEntity<>(toDoListService.findListById(id), HttpStatus.OK);
    }
}
