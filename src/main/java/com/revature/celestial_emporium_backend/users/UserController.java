package com.revature.celestial_emporium_backend.users;

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
    private ResponseEntity<List<User>> getUsers(){
        return null;
    }
    //todo: Implement
    @GetMapping("/{id}")
    private ResponseEntity<User> getUserByID(@PathVariable int id){
        return null;
    }
}
