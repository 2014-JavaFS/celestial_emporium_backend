package com.revature.celestial_emporium_backend.util.auth;

import com.revature.celestial_emporium_backend.users.User;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.Optional;

@Service
public class AuthService {

    public Optional<User> login(LoginForm loginForm) throws AuthenticationException {
//        User user = userService.findByUsernameAndPassword(loginForm.getUsername());
        return null;
    }
}
