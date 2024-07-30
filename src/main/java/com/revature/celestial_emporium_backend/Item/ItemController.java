package com.revature.celestial_emporium_backend.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) { this.itemService = itemService; }

    @GetMapping
    public @ResponseBody List<Item> getAllItems() { return itemService.findAll();};

    @PostMapping
    private ResponseEntity<Item> postNewItem(@RequestBody Item item) {
        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.create(item));
    }
}
