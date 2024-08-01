package com.revature.celestial_emporium_backend.Inventory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
    @Query("FROM Inventory i WHERE i.user.userIdNumber = :id")
    Optional<List<Inventory>> findByUserIdNumber(int id);
}
