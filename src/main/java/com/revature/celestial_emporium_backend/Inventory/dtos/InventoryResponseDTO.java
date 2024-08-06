package com.revature.celestial_emporium_backend.Inventory.dtos;

import com.revature.celestial_emporium_backend.Inventory.Inventory;
import com.revature.celestial_emporium_backend.Item.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryResponseDTO {
    private int inventoryId;
    private Item item;
    private int quantity;
    private int price;

    public InventoryResponseDTO(Inventory inventory) {
        this.inventoryId = inventory.getInventoryId();
        this.item = inventory.getItem();
        this.quantity = inventory.getQuantity();
        this.price = inventory.getPrice();
    }
}
