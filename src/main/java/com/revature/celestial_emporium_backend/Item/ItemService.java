package com.revature.celestial_emporium_backend.Item;

import com.revature.celestial_emporium_backend.util.exceptions.DataNotFoundException;
import com.revature.celestial_emporium_backend.util.exceptions.InvalidInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) { this.itemRepository = itemRepository;   }

    public List<Item> findAll() {
        List<Item> items = itemRepository.findAll();
        if (items.isEmpty()) {
            throw new DataNotFoundException("No item information available.");
        } else {
            return items;
        }
    }

    public Item create(Item item) {
        return itemRepository.save(item);
    }

    public boolean delete(Item item) {
        itemRepository.delete(item);
        return true;
    }

    public boolean update(Item item) {
        itemRepository.save(item);
        return true;
    }

    public Item findByItemId(int itemId) throws DataNotFoundException{
        return itemRepository.findById(itemId).orElseThrow(() -> new DataNotFoundException("No item found with itemId " + itemId));
    }
}
