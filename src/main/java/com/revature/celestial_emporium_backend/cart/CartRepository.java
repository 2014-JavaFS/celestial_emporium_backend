package com.revature.celestial_emporium_backend.cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    // JpaRepository already provides the findById method that returns Optional<Cart>
    @Query("SELECT c FROM Cart c WHERE c.user.userIdNumber = :userIdNumber")
    Optional<Cart> findByUserId(@Param("userIdNumber") int userIdNumber);

}
