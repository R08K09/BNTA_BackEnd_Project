package com.example.backend_code.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @JsonIgnoreProperties({"users"})
    @ManyToMany(mappedBy = "users")
    private List<ToDoList> masterList;

    public User(String name) {
        this.name = name;
        this.masterList = new ArrayList<>();
    }

    public User() {

    }



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

    public void addList(ToDoList toDoList){
        this.masterList.add(toDoList);
    }
}
