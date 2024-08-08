package com.revature.celestial_emporium_backend.cartitem;
import com.revature.celestial_emporium_backend.util.exceptions.DataNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import com.revature.celestial_emporium_backend.Item.Item;
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

    @Transactional
    public CartItem addCartItem(int cartId, int userId, int itemId, int quantity) {

        Optional<Inventory> inventoryOptional = inventoryRepository.findById(itemId);

        if (inventoryOptional.isEmpty()) {
            throw new DataNotFoundException("Item with id " + itemId + " not found in inventory");
        }

        Inventory inventory = inventoryOptional.get();

        CartItem cartItem = new CartItem();
        Cart cart = new Cart();
        cart.setCartId(cartId);

        User user = new User();
        user.setUserIdNumber(userId);
        cartItem.setUser(user);

        cartItem.setQuantity(quantity);
        cartItem.setPrice(inventory.getPrice());
        cartItem.setInventory(inventory);

        return cartItemRepository.save(cartItem);
    }

}
