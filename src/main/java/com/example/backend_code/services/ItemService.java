package com.example.backend_code.services;

import com.example.backend_code.models.Item;
import com.example.backend_code.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public void createItem(Item item){
        itemRepository.save(item);
    }

    public void deleteItem(Long id){
        itemRepository.deleteById(id);
    }

    public void itemComplete(Long id){
        // find item based on id
        Item item = itemRepository.findById(id).get();

        // replace isComplete
        item.setCompleted(true);

        // save item
        itemRepository.save(item);
    }

    public Item findItemById(Long id){
        return itemRepository.findById(id).get();
    }

}
