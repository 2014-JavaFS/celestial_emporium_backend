package com.revature.celestial_emporium_backend.util.auth;

import com.revature.celestial_emporium_backend.users.User;
import com.revature.celestial_emporium_backend.users.UserRepository;
import com.revature.celestial_emporium_backend.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
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


    private final AuthenticationManager authenticationManager;
    private final AuthService authService;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    /**
     * <h5>Constructs a new AuthController with AuthService injected.</h5>
     * @param authService the AuthService to be used by this controller
     */
    @Autowired
    public AuthController(AuthService authService, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder,
                          UserService userService) {
        this.authService = authService;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        System.out.println("Hit");
        User user = authService.register(registerDto);
        if (user != null) {
            return new ResponseEntity<>("Username is taken!", HttpStatus.BAD_REQUEST);
        }
        User registeredUser = new User(registerDto.getEmail(), passwordEncoder.encode(registerDto.getPassword()), registerDto.getFirstName(), registerDto.getLastName(), registerDto.getAddress());
        userService.createUser(registeredUser);
        return new ResponseEntity<>("User was successfully register", HttpStatus.OK);
    }

    /**
     * <h5>Handles the login request.</h5>
     * <p>Calls the login method in AuthService</p>
     *
     * @param loginDto the form contianing login details
     */

    @PostMapping("/login")
    private ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        try {
            User user = authService.login(loginDto);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK).body(loginDto.getEmail());
    }

}
