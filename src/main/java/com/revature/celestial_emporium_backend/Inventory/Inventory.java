package com.revature.celestial_emporium_backend.Inventory;

import com.revature.celestial_emporium_backend.Inventory.dtos.InventoryRequestDTO;
import com.revature.celestial_emporium_backend.Item.Item;
import com.revature.celestial_emporium_backend.users.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="inventories")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int inventoryId;

    @ManyToOne
    @JoinColumn(name = "user_id_number")
    private User user;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private int quantity;
    private int price;


    public Inventory(InventoryRequestDTO inventoryRequestDTO) {
        User user = new User();
        user.setUserIdNumber(inventoryRequestDTO.getUserIdNumber());
        this.user = user;

        Item item = new Item();
        item.setItemId(item.getItemId());
        this.item = item;

        this.quantity = inventoryRequestDTO.getQuantity();
        this.price = inventoryRequestDTO.getPrice();
    }
}
