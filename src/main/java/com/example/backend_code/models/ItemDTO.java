package com.example.backend_code.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ItemDTO {

    private String taskName;

    private LocalDate dueDate;

    private Long listId;

    private Priority priority;

    private boolean isCompleted;

    public ItemDTO(String taskName, String dueDate, Priority priority, Long listId){
        this.taskName = taskName;
        this.dueDate = LocalDate.parse(dueDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.priority = priority;
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

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = LocalDate.parse(dueDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
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

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
