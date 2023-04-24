package com.example.backend_code.models;

import java.util.ArrayList;
import java.util.List;

public class ListDTO {

    private Long id;
    private String listName;
    private List<Long> itemIds;
    private boolean isCompleted;

//CONSTRUCTOR
    public ListDTO(String listName, List itemIds){
        this.listName = listName;
        this.itemIds = itemIds;
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

    public List<Long> getItemIds() {
        return itemIds;
    }

    public void setItemIds(List<Long> itemIds) {
        this.itemIds = itemIds;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }


}
