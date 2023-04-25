package com.example.backend_code.models;

import java.util.ArrayList;
import java.util.List;

public class ItemDTO {

    private String taskName;

    private String dueDate;

    private Long listId;

    private boolean isCompleted;

    public ItemDTO(String taskName, String dueDate, Long listId){
        this.taskName = taskName;
        this.dueDate = dueDate;
        this.listId = listId;
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

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public Long getListId() {
        return listId;
    }
    public void setListId(Long listId) {
        this.listId = listId;
    }
}
