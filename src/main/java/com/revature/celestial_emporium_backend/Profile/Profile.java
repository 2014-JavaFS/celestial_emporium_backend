package com.revature.celestial_emporium_backend.Profile;

import com.revature.celestial_emporium_backend.Profile.dtos.ProfileRequestDTO;
import com.revature.celestial_emporium_backend.users.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
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
    private String birthday;
    private String location;
    private String playerClass;
    private String background;

    public Profile(ProfileRequestDTO profileRequestDTO) {
        User user = new User();
        user.setUserIdNumber(profileRequestDTO.getUserIdNumber());
        user.setFirstName(profileRequestDTO.getFirstName());
        user.setLastName(profileRequestDTO.getLastName());
        this.user = user;

        this.bio = profileRequestDTO.getBio();
        this.birthday = profileRequestDTO.getBirthday();
        this.location = profileRequestDTO.getLocation();
        this.playerClass = profileRequestDTO.getPlayerClass();
        this.background = profileRequestDTO.getBackground();
    }
}
