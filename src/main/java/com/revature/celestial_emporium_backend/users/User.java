package com.revature.celestial_emporium_backend.users;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userIdNumber;
    @Column(unique = true, nullable = false)
    @Email(message = "An email address must be in the form of _@_._; please try again.")
    private String email;
    @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,30}",
            message = "A password must be between 8 and 30 characters and include at least one uppercase letter, " +
                    "one lowercase letter, and one special character. Please try again.")
    @Column(nullable = false)
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    @Enumerated(EnumType.STRING)
    private MemberType memberTier;

    public enum MemberType{
        NONE, BUYER, SELLER, ADMIN, WAUKEEN
    }

    public User(String email, String password, String firstName, String lastName, String address) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.memberTier = MemberType.BUYER;
    }

    /*
    User Roles:
        1) None: A completely new user may browse the inventory.
        2) Buyer: A registered user may browse inventory, buy items, and change their user profile
        3) Seller: A seller may list items; by default all buyers are also sellers unless privilege is changed
        4) Admin: Delete individual accounts and items from the master catalog as well as certain universal admin functions.
        5) Waukeen: Goddess of trade may at her sole, and mercurial, discretion destroy the entire database.
     */


}
