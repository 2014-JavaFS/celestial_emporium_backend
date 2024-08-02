package com.revature.celestial_emporium_backend.Profile.dtos;

import java.util.Date;

public class ProfileRequestDTO {
    private int userIdNumber;
    private String bio;
    private Date birthday;
    private String location;
    private String playerClass;
    private String background;

    public ProfileRequestDTO(int userIdNumber, String bio, Date birthday, String location, String playerClass, String background) {
        this.userIdNumber = userIdNumber;
        this.bio = bio;
        this.birthday = birthday;
        this.location = location;
        this.playerClass = playerClass;
        this.background = background;
    }

    public int getUserIdNumber() {
        return userIdNumber;
    }

    public void setUserIdNumber(int userIdNumber) {
        this.userIdNumber = userIdNumber;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }
}
