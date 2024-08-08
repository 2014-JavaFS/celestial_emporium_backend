package com.revature.celestial_emporium_backend.cartitem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="http://localhost:5173")
@RestController
@RequestMapping("/cart-items")
public class CartItemController {
    private final CartItemService cartItemService;

    @Autowired
    public CartItemController (CartItemService cartItemService) { this.cartItemService = cartItemService; }

    @GetMapping
    public @ResponseBody List<CartItem> getAllCartItems() { return cartItemService.findAll(); }

    @PostMapping
    public ResponseEntity<CartItem> postNewCartItem(@RequestBody CartItem cartItem) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cartItemService.create(cartItem));
    }

    @GetMapping("/{userId}")
    private ResponseEntity<Optional<CartItem>> getCartItemByUser(@PathVariable int userId) {
        return ResponseEntity.ok(cartItemService.findByUser(userId));
    }

    @PutMapping
    private ResponseEntity<Boolean> putUpdateCartItem(@RequestBody CartItem updatedCartItem) {
        return ResponseEntity.ok(cartItemService.update(updatedCartItem));
    }

    @DeleteMapping
    private ResponseEntity<Boolean> deleteCartItem(@PathVariable int id) {
        return ResponseEntity.ok(cartItemService.delete(id));
    }

    @DeleteMapping("/checkout/{userId}")
    public void checkout(@PathVariable int userId) {
        cartItemService.checkout(userId);
    }

}
