package com.revature.celestial_emporium_backend.util.auth;

import com.revature.celestial_emporium_backend.users.User;
import lombok.Data;

@Data
public class RegisterDto {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
}
