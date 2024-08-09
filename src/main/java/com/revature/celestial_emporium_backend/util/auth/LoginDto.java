package com.revature.celestial_emporium_backend.util.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class LoginDto {
    private String email;
    private String password;
}
