package com.revature.celestial_emporium_backend.users;

import com.revature.celestial_emporium_backend.util.exceptions.InsufficientPrivileges;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    //todo: Implement
    @GetMapping("/{id}")
    private ResponseEntity<User> getUserByID(@PathVariable int id){
        return null;
    }
}
