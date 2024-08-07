package com.revature.celestial_emporium_backend.Profile.dtos;

import com.revature.celestial_emporium_backend.Profile.Profile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileResponseDTO {
    private int profileId;
    private String firstName;
    private String lastName;
    private String bio;
    private String birthday;
    private String location;
    private String playerClass;
    private String background;

    public ProfileResponseDTO(Profile profile) {
        this.profileId = profile.getProfileId();
        this.firstName = profile.getUser().getFirstName();
        this.lastName = profile.getUser().getLastName();
        this.bio = profile.getBio();
        this.birthday = profile.getBirthday();
        this.location = profile.getLocation();
        this.playerClass = profile.getPlayerClass();
        this.background = profile.getBackground();
    }
}
