package com.example.backend_code.models;

import jakarta.persistence.*;

@Entity
@Table(name = "ToDoLists")
public class ToDoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String listName;

    @Column
    private boolean isCompleted;



}
