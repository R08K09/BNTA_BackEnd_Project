package com.example.backend_code.components;

import com.example.backend_code.models.Item;
import com.example.backend_code.models.ToDoList;
import com.example.backend_code.models.User;
import com.example.backend_code.repositories.ItemRepository;
import com.example.backend_code.repositories.ToDoListRepository;
import com.example.backend_code.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

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
//        make user
        User user = new User("John");
        userRepository.save(user);

//        make a to-do list
        ToDoList toDoListOne = new ToDoList("House chores", false);
        toDoListRepository.save(toDoListOne);
        ToDoList toDoListTwo = new ToDoList("Shopping List", false);
        toDoListRepository.save(toDoListTwo);

//        make items
        Item itemOne = new Item("Vacuum", "20/03/2022", toDoListOne);
        itemRepository.save(itemOne);
        Item itemTwo = new Item("Fold clothes", "01/01/2023", toDoListOne);
        itemRepository.save(itemTwo);
        Item itemThree = new Item("Milk", "12/05/2020", toDoListTwo);
        itemRepository.save(itemThree);

//        add items to their lists
        toDoListOne.addItem(itemOne);
        toDoListRepository.save(toDoListOne);

        toDoListOne.addItem(itemTwo);
        toDoListRepository.save(toDoListOne);

        toDoListTwo.addItem(itemThree);
        toDoListRepository.save(toDoListTwo);





    }
}
