package com.revature.celestial_emporium_backend.cartitem;
import com.revature.celestial_emporium_backend.util.exceptions.DataNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.revature.celestial_emporium_backend.cart.Cart;
import com.revature.celestial_emporium_backend.users.User;
import com.revature.celestial_emporium_backend.Inventory.Inventory;
import com.revature.celestial_emporium_backend.Inventory.InventoryRepository;

@Service
public class CartItemService {
    private final CartItemRepository cartItemRepository;

    @Autowired
    public CartItemService(CartItemRepository cartItemRepository) { this.cartItemRepository = cartItemRepository; }

    @Autowired
    private InventoryRepository inventoryRepository;


    public List<CartItem> findAll() {
        List<CartItem> cartItems = cartItemRepository.findAll();

        if (cartItems.isEmpty()) {
            throw new DataNotFoundException("No cart item information available");
        }
        return cartItems;
    }

    public Optional<CartItem> findById(int id) { return cartItemRepository.findById(id); }
    public Optional<CartItem> findByUser(int id) { return cartItemRepository.findByUser(id); }

    public CartItem create(CartItem cartItem) { return cartItemRepository.save(cartItem); }

    @Transactional
    public boolean delete(int cartItemId) {
        cartItemRepository.deleteById(cartItemId);
        return true;
    }

    @Transactional
    public boolean update(CartItem cartItem) {
        cartItemRepository.save(cartItem);
        return true;
    }

    public void checkout(int userId) {
        cartItemRepository.deleteByUserId(userId);
    }

}
