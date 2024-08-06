package com.revature.celestial_emporium_backend.users;

import com.revature.celestial_emporium_backend.util.exceptions.InsufficientPrivileges;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    //todo: Implement
    @GetMapping
    private List<User> getAllUsers(@RequestHeader String userTier){
        if(userTier.equals("ADMIN")) return userService.findAll();
        else throw new InsufficientPrivileges("Only an admin may view all users.");
    }

    @GetMapping("/{userId}")
    private ResponseEntity<User> getUserByID(@PathVariable int userId) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findById(userId));
    }

    @PostMapping()
    private ResponseEntity<User> createUser(@RequestBody User newUser){
        User registeredUser = userService.createUser(newUser);
        if(registeredUser != null) return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(newUser);
    }

    @PutMapping
    private ResponseEntity<User> updateUser(@RequestHeader int userIdNumber, @RequestBody User updatedUser)
            throws AuthenticationException {
        if(userIdNumber==updatedUser.getUserIdNumber()){
            return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(updatedUser));
        }else throw new AuthenticationException("You must be logged in as a user to update.");
    }
}
