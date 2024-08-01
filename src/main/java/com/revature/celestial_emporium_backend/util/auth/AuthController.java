package com.revature.celestial_emporium_backend.util.auth;

import com.revature.celestial_emporium_backend.users.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;

/**
 * <h5>REST controller that handles authentication-related requests</h5>
 * <p>This controller maps all requests to <em>"/auth"</em>.
 * It uses AuthService to perform authentication logic.</p>
 */
@RestController
@RequestMapping("/auth")
public class AuthController {


    private final AuthService authService;

    /**
     * <h5>Constructs a new AuthController with AuthService injected.</h5>
     * @param authService the AuthService to be used by this controller
     */
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    /**
     * <h5>Handles the login request.</h5>
     * <p>Calls the login method in AuthService</p>
     *
     * @param loginForm the form contianing login details
     */

    @PostMapping("/login")
    private void login(@RequestBody LoginForm loginForm) {
        try {
            User user = authService.login(loginForm).orElse(null);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
    }

}
