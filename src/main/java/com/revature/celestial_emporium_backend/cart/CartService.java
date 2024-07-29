package com.revature.celestial_emporium_backend.cart;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.zip.DataFormatException;

@Service
public class CartService {
    private final CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public List<Cart> findAll() {
        List<Cart> carts = cartRepository.findAll();

        if (carts.isEmpty()) {
            throw new DataNotFoundException("No cart information available");
        }
        return carts;
    }

    public Optional<Cart> findById(int id) {
        return cartRepository.findById(id);
    }

    public Cart create(Cart cart) {
        return cartRepository.save(cart);
    }

    @Transactional
    public boolean delete(int cartId) {
        cartRepository.deleteById(cartId);
        return true;
    }

    @Transactional
    public boolean update(Cart cart) {
        cartRepository.save(cart);
        return true;
    }








}
