package com.revature.celestial_emporium_backend.cart;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
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
        } else {
            return carts;
        }
    }

    public Cart findById(int cartId) {
        Cart foundCart = cartRepository.findById(cartId);
        return foundCart;
    }

    public Cart create(Cart cart) {
        return cartRepository.create(cart);
    }

    public boolean delete(Cart cart) {
        cartRepository.delete(cart);
        return true;
    }

    public boolean update(Cart cart) {
        cartRepository.update(cart);
        return true;
    }








}
