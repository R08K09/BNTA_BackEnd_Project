package com.example.backend_code.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;


@Entity
@Table(name = "items")
public class Item {

//    PROPERTIES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String taskName;

    @Column
    private LocalDate dueDate;

    @Column
    private Priority priority;

    @Column
    private boolean isCompleted;

    @JsonIgnoreProperties({"items"})
    @ManyToOne
    @JoinColumn(name = "todolist_id")
    private ToDoList toDoList;


//    CONSTRUCTOR
    public Item(String taskName, String dueDate, Priority priority){
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = LocalDate.parse(dueDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.isCompleted = false;
    }

//    DEFAULT CONSTRUCTOR
    public Item(){

    }

//    GETTERS & SETTERS
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

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public ToDoList getToDoList() {
        return toDoList;
    }

    public void setToDoList(ToDoList toDoList) {
        this.toDoList = toDoList;
    }

    public Boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
