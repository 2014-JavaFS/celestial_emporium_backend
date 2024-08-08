package com.revature.celestial_emporium_backend.Profile;

import com.revature.celestial_emporium_backend.Profile.dtos.ProfileRequestDTO;
import com.revature.celestial_emporium_backend.Profile.dtos.ProfileResponseDTO;
import com.revature.celestial_emporium_backend.users.User;
import com.revature.celestial_emporium_backend.users.UserService;
import com.revature.celestial_emporium_backend.util.exceptions.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:5173")
@RestController
@RequestMapping("/profiles")
public class ProfileController {
    private final ProfileService profileService;
    private final UserService userService;

    @Autowired
    public ProfileController(ProfileService profileService, UserService userService) {
        this.profileService = profileService;
        this.userService = userService;
    }

    @PostMapping
    private ResponseEntity<ProfileResponseDTO> postProfile(@RequestBody ProfileRequestDTO profileRequestDTO) {
        Profile profile = new Profile(profileRequestDTO);
        User user = userService.findByUserIdNumber(profileRequestDTO.getUserIdNumber());
        profile.setUser(user);

        ProfileResponseDTO profileResponseDTO = profileService.createProfile(profile);

        return ResponseEntity.status(HttpStatus.CREATED).body(profileResponseDTO);
    }

    @GetMapping
    private ResponseEntity<List<Profile>> getAllProfiles() {
        return ResponseEntity.ok(profileService.findAll());
    }

    @GetMapping("/{userIdNumber}")
    private ResponseEntity<ProfileResponseDTO> showUserProfile(@PathVariable int userIdNumber) {
        return ResponseEntity.ok(profileService.findByUserId(userIdNumber));
    }

//    @PutMapping("/{userIdNumber}")
//    private ResponseEntity<ProfileResponseDTO> updateProfile( @PathVariable int userIdNumber, @RequestBody ProfileRequestDTO profileRequestDTO) {
//        Profile profile = new Profile(profileRequestDTO);
//        User user = userService.findByUserIdNumber(userIdNumber);
//        profile.setUser(user);
//
//        ProfileResponseDTO profileResponseDTO = profileService.updateProfile(profile);
//
//        return ResponseEntity.status(HttpStatus.OK).body(profileResponseDTO);
//    }

    @PatchMapping("/{userIdNumber}")
    private ResponseEntity<ProfileResponseDTO> updateProfile( @PathVariable int userIdNumber, @RequestBody ProfileRequestDTO profileRequestDTO) {
        try {
            ProfileResponseDTO profileResponseDTO = profileService.partialUpdate(userIdNumber,profileRequestDTO);
            return ResponseEntity.status(HttpStatus.OK).body(profileResponseDTO);
        } catch (DataNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping
    private ResponseEntity<Void> deleteProfile(@RequestHeader int profileId, @RequestHeader int userIdNumber) {
        Profile profile = profileService.findById(profileId);
        if(profile.getUser().getUserIdNumber() == userIdNumber) {
            profileService.deleteProfile(profile);
        }

        return ResponseEntity.noContent().build();
    }
}
