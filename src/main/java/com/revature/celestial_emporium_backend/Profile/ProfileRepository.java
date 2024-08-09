package com.revature.celestial_emporium_backend.Profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    @Query("FROM Profile p WHERE p.user.userIdNumber = :id")
    Optional<Profile> findByUserIdNumber(int id);
}
