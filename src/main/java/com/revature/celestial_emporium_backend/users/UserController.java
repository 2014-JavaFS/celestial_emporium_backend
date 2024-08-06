package com.revature.celestial_emporium_backend.users;

import com.revature.celestial_emporium_backend.util.exceptions.InsufficientPrivileges;
import com.revature.celestial_emporium_backend.util.exceptions.InvalidInputException;
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
        if(!isValidPassword(newUser.getPassword())) return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(newUser);
        if(registeredUser != null) return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(newUser);
    }

    @PutMapping
    private ResponseEntity<User> updateUser(@RequestHeader int userIdNumber, @RequestBody User updatedUser)
            throws AuthenticationException {
        if(userIdNumber==updatedUser.getUserIdNumber()){
            if(!isValidPassword(updatedUser.getPassword())) return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(updatedUser);
            return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(updatedUser));
        }else throw new AuthenticationException("You must be logged in as a user to update.");
    }

    @PutMapping
    private ResponseEntity<User> updateUserTier(@RequestHeader User.MemberType adminMemberType,
                                                @RequestBody User updatedUser, @RequestBody User.MemberType newLevel)
            throws AuthenticationException{
        if(adminMemberType == User.MemberType.ADMIN || adminMemberType == User.MemberType.WAUKEEN){
            if(newLevel != User.MemberType.WAUKEEN)
                return ResponseEntity.status(HttpStatus.OK).body(userService.updateUserTierLevel(updatedUser, newLevel));
            else throw new AuthenticationException("Please stand by to be smited for attempting to usurp a god.");
        }else throw new AuthenticationException("You must be logged in as an admin or higher to access this function.");
    }

    private boolean isValidPassword(String password) {
        String validPasswordRegex = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,30}";
        if (!password.matches(validPasswordRegex)) {
            throw new InvalidInputException("A password must be between 8 and 30 characters and include at least one uppercase " +
                    "letter, one lowercase letter, and one special character. Please try again.");
        } else return true;
    }
}
