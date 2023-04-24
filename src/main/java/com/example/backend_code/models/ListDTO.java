package com.example.backend_code.models;

import java.util.ArrayList;
import java.util.List;

public class ListDTO {

    private Long id;
    private String listName;
    private List<Item> items;
    private boolean isCompleted;

//CONSTRUCTOR
    public ListDTO(String listName, Item items){
        this.listName = listName;
        this.items = new ArrayList<Item>();
        this.isCompleted = false;
    }


//DEFAULT CONSTRUCTOR
    public ListDTO(){

    }


//SETTERS AND GETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

//METHODS

    public void addItem(Item item){
        this.items.add(item);
    }

    public void removeItem(Item item){
        this.items.remove(item);
    }

}
