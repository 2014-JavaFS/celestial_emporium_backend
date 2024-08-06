package com.revature.celestial_emporium_backend.Inventory.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryRequestDTO {
    private int userIdNumber;
    private int itemId;
    private int quantity;
    private int price;

}
