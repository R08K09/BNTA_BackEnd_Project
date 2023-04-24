package com.example.backend_code.models;

import java.util.ArrayList;
import java.util.List;

public class ItemDTO {

    private String taskName;

    private String dueDate;

    private List<Long> listIds;

    private boolean isCompleted;

    public ItemDTO(String taskName, String dueDate, List listIds){
        this.taskName = taskName;
        this.dueDate = dueDate;
        this.listIds = listIds;
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

    public List<Long> getListIds() {
        return listIds;
    }

    public void setListIds(List<Long> listIds) {
        this.listIds = listIds;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
