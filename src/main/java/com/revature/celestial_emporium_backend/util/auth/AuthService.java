package com.revature.celestial_emporium_backend.util.auth;

import com.revature.celestial_emporium_backend.users.User;
import com.revature.celestial_emporium_backend.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

@Service
public class AuthService {

    private final UserService userService;

    @Autowired
    public AuthService(UserService userService) {
        this.userService = userService;
    }

    public User login(LoginDto loginDto) throws AuthenticationException {
        int id = userService.lookupUserIdByEmail(loginDto.getEmail());
        User user = userService.findById(id);
        if (user.getPassword().equals(loginDto.getPassword())) {
            return user;
        } else {
            throw new AuthenticationException();
        }
    }
}
