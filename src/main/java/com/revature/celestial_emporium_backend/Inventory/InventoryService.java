package com.revature.celestial_emporium_backend.Inventory;

import com.revature.celestial_emporium_backend.Inventory.dtos.InventoryResponseDTO;
import com.revature.celestial_emporium_backend.util.exceptions.DataNotFoundException;
import com.revature.celestial_emporium_backend.util.exceptions.InvalidInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository) {this.inventoryRepository = inventoryRepository;}

    public InventoryResponseDTO createInventory(Inventory newInventory) {
        Optional<Inventory> inventory = Optional.of(inventoryRepository.save(newInventory));
        inventory.orElseThrow(() -> new InvalidInputException("Double-Check Inventory Info"));

        return inventory.map(InventoryResponseDTO::new).get();
    }

    public List<Inventory> findAll() {return inventoryRepository.findAll();}

    public List<InventoryResponseDTO> findAllInventoriesByUserIdNumber(int userIdNumber) {
        return inventoryRepository.findByUserIdNumber(userIdNumber)
                .orElseThrow(() -> new DataNotFoundException("No inventories with userIdNumber " + userIdNumber))
                .stream()
                .map(InventoryResponseDTO::new)
                .toList();
    }

    public Inventory findById(int number) {
        Optional<Inventory> inventory = inventoryRepository.findById(number);
        inventory.orElseThrow(() -> new DataNotFoundException("No inventory found with itemId" + number));

        return inventory.get();
    }

    public InventoryResponseDTO updateInventory(Inventory updateInventory) {
        Optional<Inventory> inventory = Optional.of(inventoryRepository.save(updateInventory));
        inventory.orElseThrow(() -> new InvalidInputException("Double-Check Inventory Info"));

        return inventory.map(InventoryResponseDTO::new).get();
    }

    public void deleteInventory(Inventory deletedInventory) {
        inventoryRepository.delete(deletedInventory);
    }
//    public List<Inventory> findAllByUserId(int userId) {
//        List<Inventory> inventories = inventoryRepository.findAllInventoriesByUserIdNumber(userId);
//    }
}
