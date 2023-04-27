package com.example.backend_code.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ToDoLists")
public class ToDoList {

//    PROPERTIES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String listName;

    @Column
    private boolean isCompleted;

    @ManyToMany(mappedBy = "masterList")
    @JsonIgnoreProperties({"masterList"})
    private List<User> users;

    @JsonIgnoreProperties({"toDoList"})
    @OneToMany(mappedBy = "toDoList")
    private List<Item> items;

//    CONSTRUCTOR
    public ToDoList(String listName){
        this.listName = listName;
        this.isCompleted = false;
        this.users = new ArrayList<>();
        this.items = new ArrayList<>();
    }

//    DEFAULT CONSTRUCTOR
    public ToDoList(){

    }

//    GETTERS & SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getListName() {
        return this.listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public Boolean getIsCompleted() {
        return this.isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public List<User> getUsers() {
        return this.users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Item> getItems() {
        return this.items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

//    METHODS
    public void addItem(Item item){
        this.items.add(item);
    }

    public void removeItem(Item item){
        this.items.remove(item);
    }

    public void addUser(User user){
        this.users.add(user);
    }

    public void removeUser(User user){
        this.users.remove(user);
    }

}
