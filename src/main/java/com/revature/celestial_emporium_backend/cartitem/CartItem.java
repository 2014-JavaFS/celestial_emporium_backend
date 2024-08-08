package com.revature.celestial_emporium_backend.cartitem;

import com.revature.celestial_emporium_backend.Inventory.Inventory;
import com.revature.celestial_emporium_backend.Item.Item;
import com.revature.celestial_emporium_backend.cart.Cart;
import com.revature.celestial_emporium_backend.users.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cartitems")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private int price;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;



}
