package com.revature.celestial_emporium_backend.cartitem;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cartitems")
public class CartItem {

    @OneToOne
    @JoinColumn(name = "cart_id")
    private int cartId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private int userId;

    @ManyToMany
    @JoinColumn(name = "item_id")
    private int itemId;

    private int quantity;



}
