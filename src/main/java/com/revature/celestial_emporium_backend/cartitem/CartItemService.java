package com.revature.celestial_emporium_backend.cartitem;
import com.revature.celestial_emporium_backend.cart.CartRepository;
import com.revature.celestial_emporium_backend.users.UserRepository;
import com.revature.celestial_emporium_backend.util.exceptions.DataNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.revature.celestial_emporium_backend.cart.Cart;
import com.revature.celestial_emporium_backend.Inventory.InventoryRepository;

@Service
public class CartItemService {
    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;

    @Autowired
    public CartItemService(CartItemRepository cartItemRepository, CartRepository cartRepository, UserRepository userRepository) {
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
    }

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

    @Transactional
    public CartItem create(CartItem cartItem) {
        int userId = cartItem.getUser().getUserIdNumber();

        Optional<Cart> existingCart = cartRepository.findByUserId(userId);

        Cart cart;
        if (existingCart.isEmpty()) {

            cart = new Cart();
            cart.setUser(cartItem.getUser());
            cart = cartRepository.save(cart);
        } else {
            cart = existingCart.get();
        }
        cartItem.setCart(cart);

        return cartItemRepository.save(cartItem);
    }

}
