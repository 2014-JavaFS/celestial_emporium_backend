package com.revature.celestial_emporium_backend.users;

import com.revature.celestial_emporium_backend.util.exceptions.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findByUserIdNumber(int userIdNumber) throws DataNotFoundException {
        return userRepository.findById(userIdNumber).orElseThrow(() -> new DataNotFoundException("No User found with userIdNumber " + userIdNumber));
    }
}
