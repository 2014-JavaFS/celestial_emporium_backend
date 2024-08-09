package com.revature.celestial_emporium_backend.users.dtos;

import com.revature.celestial_emporium_backend.users.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
    private int userIdNumber;
    private String email;
    private String firstName;
    private String lastName;

    public UserResponseDTO(User user) {
        this.userIdNumber = user.getUserIdNumber();
        this.email = user.getEmail();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
    }
}
