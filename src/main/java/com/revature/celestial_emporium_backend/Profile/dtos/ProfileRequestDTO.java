package com.revature.celestial_emporium_backend.Profile.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileRequestDTO {
    private int userIdNumber;
    private String firstName;
    private String lastName;
    private String bio;
    private String birthday;
    private String location;
    private String playerClass;
    private String background;
}
