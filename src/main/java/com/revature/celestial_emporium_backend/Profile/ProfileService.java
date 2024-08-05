package com.revature.celestial_emporium_backend.Profile;

import com.revature.celestial_emporium_backend.Profile.dtos.ProfileResponseDTO;
import com.revature.celestial_emporium_backend.util.exceptions.DataNotFoundException;
import com.revature.celestial_emporium_backend.util.exceptions.InvalidInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {
    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileService(ProfileRepository profileRepository) {this.profileRepository = profileRepository;}

    public ProfileResponseDTO createProfile(Profile newProfile) {
        Optional<Profile> profile = Optional.of(profileRepository.save(newProfile));
        profile.orElseThrow(() -> new InvalidInputException("Double-Check Profile Info"));
        return profile.map(ProfileResponseDTO::new).get();
    }

    public List<Profile> findAll() {return profileRepository.findAll();}

    public ProfileResponseDTO findByUserId(int userIdNumber) {
        Optional<Profile> profile = profileRepository.findByUserIdNumber(userIdNumber);
        profile.orElseThrow(() -> new DataNotFoundException("No profile with userIdNumber " + userIdNumber));
        return profile.map(ProfileResponseDTO::new).get();
    }

    public ProfileResponseDTO updateProfile(Profile updateProfile) {
        Optional<Profile> profile = Optional.of(profileRepository.save(updateProfile));
        profile.orElseThrow(() -> new InvalidInputException("Double-Check Profile Info"));
        return profile.map(ProfileResponseDTO::new).get();
    }


    public void deleteProfile(Profile deletedProfile) {
        profileRepository.delete(deletedProfile);
    }

    public Profile findById(int profileId) {
        Optional<Profile> profile = profileRepository.findById(profileId);
        profile.orElseThrow(() -> new DataNotFoundException("No profile found with profileId" + profileId));

        return profile.get();
    }
}
