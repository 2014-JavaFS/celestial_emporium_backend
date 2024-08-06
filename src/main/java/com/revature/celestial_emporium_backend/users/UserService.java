package com.revature.celestial_emporium_backend.users;

import com.revature.celestial_emporium_backend.util.exceptions.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
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

    public int lookupUserIdByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow().getUserIdNumber();
    }

    public User findById(int userId){
        return userRepository.findById(userId).orElseThrow();
    }

    public User createUser(User newUser) {
        return userRepository.save(newUser);
    }

    public User updateUser(User updatedUser) {
        updatedUser.setMemberTier(findById(updatedUser.getUserIdNumber()).getMemberTier());
        return userRepository.save(updatedUser);
    }

    protected User updateUserTierLevel(User user, User.MemberType newLevel){
        user.setMemberTier(newLevel);
        return userRepository.save(user);
    }
}
