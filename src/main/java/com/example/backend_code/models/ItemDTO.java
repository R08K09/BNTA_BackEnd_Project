package com.example.backend_code.models;

import java.util.ArrayList;
import java.util.List;

public class ItemDTO {

    private String taskName;

    private String dueDate;

    private List<ToDoList> toDoLists;

    private boolean isCompleted;

    public ItemDTO(String taskName, String dueDate){
        this.taskName = taskName;
        this.dueDate = dueDate;
        this.toDoLists = new ArrayList<>();
        this.isCompleted = false;
    }

    public ItemDTO(){

    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public List<ToDoList> getToDoLists() {
        return toDoLists;
    }

    public void setToDoLists(List<ToDoList> toDoLists) {
        this.toDoLists = toDoLists;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
