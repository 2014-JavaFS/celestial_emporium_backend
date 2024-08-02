package com.revature.celestial_emporium_backend.Profile.dtos;

import com.revature.celestial_emporium_backend.Profile.Profile;

import java.util.Date;

public class ProfileResponseDTO {
    private int profileId;
    private String bio;
    private Date birthday;
    private String location;
    private String playerClass;
    private String background;

    public ProfileResponseDTO() {
    }

    public ProfileResponseDTO(int profileId, String bio, Date birthday, String location, String playerClass, String background) {
        this.profileId = profileId;
        this.bio = bio;
        this.birthday = birthday;
        this.location = location;
        this.playerClass = playerClass;
        this.background = background;
    }

    public ProfileResponseDTO(Profile profile) {
        this.profileId = profile.getProfileId();
        this.bio = profile.getBio();
        this.birthday = profile.getBirthday();
        this.location = profile.getLocation();
        this.playerClass = profile.getPlayerClass();
        this.background = profile.getBackground();
    }
}
