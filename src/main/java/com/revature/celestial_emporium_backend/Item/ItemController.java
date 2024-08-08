package com.revature.celestial_emporium_backend.Item;

import com.revature.celestial_emporium_backend.util.exceptions.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) { this.itemService = itemService; }


    @GetMapping
    public @ResponseBody List<Item> getAllItems() { return itemService.findAll();};

    @GetMapping("/{itemId}")
    public ResponseEntity<Item> getItemById(@PathVariable int itemId) {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.findByItemId(itemId));
    }

    @PostMapping
    private ResponseEntity<Item> postNewItem(@RequestBody Item item) {
        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.create(item));
    }

    @PutMapping
    public ResponseEntity<Item> updateItem(@RequestBody Item updatedItem){
        return ResponseEntity.status(HttpStatus.OK).body(itemService.updateItem(updatedItem));
    }

    @DeleteMapping
    public  ResponseEntity<Void> deleteItem(@RequestBody Item deletedItem) {
        itemService.deleteItem(deletedItem);
        return ResponseEntity.noContent().build();
    }
}
