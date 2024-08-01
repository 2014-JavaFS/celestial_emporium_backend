package com.revature.celestial_emporium_backend.Inventory.dtos;

import com.revature.celestial_emporium_backend.Inventory.Inventory;
import com.revature.celestial_emporium_backend.Item.Item;


public class InventoryResponseDTO {
    private int inventoryId;
    private Item item;
    private int quantity;
    private int price;

    public InventoryResponseDTO() {
    }

    public InventoryResponseDTO(int inventoryId, Item item, int quantity, int price) {
        this.inventoryId = inventoryId;
        this.item = item;
        this.quantity = quantity;
        this.price = price;
    }

    public InventoryResponseDTO(Inventory inventory) {
        this.inventoryId = inventory.getInventoryId();
        this.item = inventory.getItem();
        this.quantity = inventory.getQuantity();
        this.price = inventory.getPrice();
    }

    public Item getItem() {return item;}

    public void setItem(Item item) {this.item = item;}
}
