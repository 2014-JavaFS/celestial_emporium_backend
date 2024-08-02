package com.revature.celestial_emporium_backend.cartitem;

import com.revature.celestial_emporium_backend.Item.Item;
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


//    @OneToOne
//    @JoinColumn(name = "cart_id")
//    private int cartId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private int userId;

    @ManyToMany
    @JoinTable(
            name = "items",
            joinColumns = @JoinColumn(name = "cart_item_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private Set<Item> items;

    private int quantity;



}
