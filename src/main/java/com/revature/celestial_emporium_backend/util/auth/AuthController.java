package com.revature.celestial_emporium_backend.util.auth;

import com.revature.celestial_emporium_backend.Profile.Profile;
import com.revature.celestial_emporium_backend.Profile.ProfileService;
import com.revature.celestial_emporium_backend.security.JwtGenerator;
import com.revature.celestial_emporium_backend.users.User;
import com.revature.celestial_emporium_backend.users.UserRepository;
import com.revature.celestial_emporium_backend.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;

/**
 * <h5>REST controller that handles authentication-related requests</h5>
 * <p>This controller maps all requests to <em>"/auth"</em>.
 * It uses AuthService to perform authentication logic.</p>
 */
@CrossOrigin(origins="http://localhost:5173")
@RestController
@RequestMapping("/auth")
public class AuthController {


    private final AuthenticationManager authenticationManager;
    private final AuthService authService;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final JwtGenerator jwtGenerator;
    private final ProfileService profileService;

    /**
     * <h5>Constructs a new AuthController with AuthService injected.</h5>
     * @param authService the AuthService to be used by this controller
     */
    @Autowired
    public AuthController(AuthService authService, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder,
                          UserService userService, JwtGenerator jwtGenerator, ProfileService profileService) {
        this.authService = authService;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.jwtGenerator = jwtGenerator;
        this.profileService = profileService;
    }

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        System.out.println("Hit");
        User user = authService.register(registerDto);
        if (user != null) {
            return new ResponseEntity<>("Username is taken!", HttpStatus.BAD_REQUEST);
        }
        User registeredUser = new User(registerDto.getEmail(), passwordEncoder.encode(registerDto.getPassword()), registerDto.getFirstName(), registerDto.getLastName(), registerDto.getAddress());
        User newUser = userService.createUser(registeredUser);
        profileService.createProfile(new Profile(newUser, "Bio here", "12/12/1212", "Somewhere", "Chef", "Background here"));
        return new ResponseEntity<>("User was successfully register", HttpStatus.OK);
    }

    /**
     * <h5>Handles the login request.</h5>
     * <p>Calls the login method in AuthService</p>
     *
     * @param loginDto the form contianing login details
     */

    @CrossOrigin(origins="http://localhost:5173")
    @PostMapping("login")
    private ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        int id = userService.lookupUserIdByEmail(loginDto.getEmail());
        String token = jwtGenerator.generateToken(authentication, id);
        return new ResponseEntity<>(new AuthResponseDto(token), HttpStatus.OK);

    }

}
