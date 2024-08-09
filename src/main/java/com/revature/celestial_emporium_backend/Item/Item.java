package com.revature.celestial_emporium_backend.Item;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(length = 1000)
    private String description;
    private String image;

}
