package com.example.backend_code.components;

import com.example.backend_code.models.Item;
import com.example.backend_code.models.Priority;
import com.example.backend_code.models.ToDoList;
import com.example.backend_code.models.User;
import com.example.backend_code.repositories.ItemRepository;
import com.example.backend_code.repositories.ToDoListRepository;
import com.example.backend_code.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ToDoListRepository toDoListRepository;

    public DataLoader(){

    }

    @Override
    public void run(ApplicationArguments args) throws Exception{

//        make users
        User user = new User("John");
        userRepository.save(user);

        User user2 = new User("Max");
        userRepository.save(user2);

        User user3 = new User("Charles");
        userRepository.save(user3);

//        make to-do lists
        ToDoList toDoListOne = new ToDoList("House chores");
        toDoListRepository.save(toDoListOne);

        ToDoList toDoListTwo = new ToDoList("Shopping List");
        toDoListRepository.save(toDoListTwo);

//        make items
        Item itemOne = new Item("Vacuum", LocalDate.of(2022, 06, 16), Priority.HIGH);
        itemRepository.save(itemOne);

        Item itemTwo = new Item("Fold clothes", LocalDate.of(2023, 01, 01), Priority.LOW);
        itemRepository.save(itemTwo);

        Item itemThree = new Item("Milk", LocalDate.of(2023, 04, 26), Priority.MEDIUM);
        itemRepository.save(itemThree);

//        set list to items
        itemOne.setToDoList(toDoListOne);
        itemRepository.save(itemOne);

        itemTwo.setToDoList(toDoListOne);
        itemRepository.save(itemTwo);

        itemThree.setToDoList(toDoListTwo);
        itemRepository.save(itemThree);

//        add users to lists
        user.addList(toDoListOne);
        user2.addList(toDoListTwo);
        user3.addList(toDoListOne);

        userRepository.save(user);
        userRepository.save(user2);
        userRepository.save(user3);


    }
}
