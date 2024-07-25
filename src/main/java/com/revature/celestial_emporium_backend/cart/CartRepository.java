package com.revature.celestial_emporium_backend.cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    // @Query("FROM carts WHERE cart_id = :cartId");
    Optional<Cart> findById(int id);
}
