package com.example.backend_code.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private List<ToDoList> masterList;

    public User(String name, Long id) {
        this.id = id;
        this.name = name;
        this.masterList = new ArrayList<>();
    }

    public User() {}



//    Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ToDoList> getMasterList() {
        return masterList;
    }

    public void setMasterList(List<ToDoList> masterList) {
        this.masterList = masterList;
    }
}
