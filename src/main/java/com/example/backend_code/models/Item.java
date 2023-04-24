package com.example.backend_code.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String taskName;

    @Column
    private String dueDate;

//    @JsonIgnoreProperties({"items"})
    @ManyToOne
    @JoinColumn(name = "todolist_id")
    private ToDoList toDoList;

    @Column
    private boolean isCompleted;
    public Item(String taskName, String dueDate){
        this.taskName = taskName;
        this.dueDate = dueDate;
        this.toDoList = toDoList;
        this.isCompleted = false;
    }

    public Item(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public ToDoList getToDoList() {
        return toDoList;
    }

    public void setToDoList(ToDoList toDoList) {
        this.toDoList = toDoList;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
