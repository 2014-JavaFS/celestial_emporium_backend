package com.revature.celestial_emporium_backend.Profile;

import com.revature.celestial_emporium_backend.users.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int profileId;

    @OneToOne
    @JoinColumn(name = "user_id_number")
    private User user;

    private String bio;
    private Date birthday;
    private String location;
    private String playerClass;
    private String background;
}
