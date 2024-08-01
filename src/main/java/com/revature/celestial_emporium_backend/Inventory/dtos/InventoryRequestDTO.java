package com.revature.celestial_emporium_backend.Inventory.dtos;

public class InventoryRequestDTO {
    private int userIdNumber;
    private int itemId;
    private int quantity;
    private int price;

    public InventoryRequestDTO(int userIdNumber, int itemId, int quantity, int price) {
        this.userIdNumber = userIdNumber;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
    }

    public int getUserIdNumber() {
        return userIdNumber;
    }

    public void setUserIdNumber(int userIdNumber) {
        this.userIdNumber = userIdNumber;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
