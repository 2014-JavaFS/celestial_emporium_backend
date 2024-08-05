package com.revature.celestial_emporium_backend.Inventory;


import com.revature.celestial_emporium_backend.Inventory.dtos.InventoryRequestDTO;
import com.revature.celestial_emporium_backend.Inventory.dtos.InventoryResponseDTO;
import com.revature.celestial_emporium_backend.Item.Item;
import com.revature.celestial_emporium_backend.Item.ItemService;
import com.revature.celestial_emporium_backend.users.User;
import com.revature.celestial_emporium_backend.users.UserService;
import com.revature.celestial_emporium_backend.util.exceptions.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventories")
public class InventoryController {
    private final InventoryService inventoryService;
    private final UserService userService;
    private final ItemService itemService;

    @Autowired
    public InventoryController(InventoryService inventoryService, UserService userService, ItemService itemService) {
        this.inventoryService = inventoryService;
        this.userService = userService;
        this.itemService = itemService;
    }

    @PostMapping
    private ResponseEntity<InventoryResponseDTO> postInventory(@RequestBody InventoryRequestDTO inventoryRequestDTO) {
        Inventory inventory = new Inventory(inventoryRequestDTO);
        User user = userService.findByUserIdNumber(inventoryRequestDTO.getUserIdNumber());
        Item item = itemService.findByItemId(inventoryRequestDTO.getItemId());
        inventory.setUser(user);
        inventory.setItem(item);

        InventoryResponseDTO inventoryResponseDTO = inventoryService.createInventory(inventory);

        return ResponseEntity.status(HttpStatus.CREATED).body(inventoryResponseDTO);
    }

    @GetMapping
    private ResponseEntity<List<Inventory>> getAllInventories() {
        return ResponseEntity.ok(inventoryService.findAll());
    }

    private ResponseEntity<List<InventoryResponseDTO>> getUserInventories(@RequestHeader int userIdNumber) {
        if(userIdNumber == 0) {
            throw new DataNotFoundException("This user does not exist or is not logged in.");
        }
        return ResponseEntity.ok(inventoryService.findAllInventoriesByUserIdNumber(userIdNumber));
    }

    @PutMapping
    private ResponseEntity<InventoryResponseDTO> updateInventory(@RequestHeader int inventoryId, @RequestBody InventoryRequestDTO inventoryRequestDTO) {
        Inventory inventory = new Inventory(inventoryRequestDTO);
        User user = userService.findByUserIdNumber(inventoryRequestDTO.getUserIdNumber());
        Item item = itemService.findByItemId(inventoryRequestDTO.getItemId());
        inventory.setUser(user);
        inventory.setItem(item);
        inventory.setInventoryId(inventoryId);

        InventoryResponseDTO inventoryResponseDTO = inventoryService.updateInventory(inventory);
        return ResponseEntity.status(HttpStatus.OK).body(inventoryResponseDTO);
    }

    @DeleteMapping
    private ResponseEntity<Void> deleteInventory(@RequestHeader int inventoryId, @RequestHeader int userIdNumber) {
        Inventory inventory = inventoryService.findById(inventoryId);
        if(inventory.getUser().getUserIdNumber() == userIdNumber) {
            inventoryService.deleteInventory(inventory);
        }
        return ResponseEntity.noContent().build();
    }
}
