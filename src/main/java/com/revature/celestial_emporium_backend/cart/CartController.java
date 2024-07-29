package com.revature.celestial_emporium_backend.cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carts")
public class CartController {
    private final CartService cartService;

    @Autowired // This is optional if only form of DI
    public CartController (CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public @ResponseBody List<Cart> getAllCarts(){
        return cartService.findAll();
    }

    @PostMapping
    public ResponseEntity<Cart> postNewCart(@RequestBody Cart cart) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cartService.create(cart));
    }

    @GetMapping("/{id}")
    private ResponseEntity<Optional<Cart>> getCartById(@PathVariable int id) {
        return ResponseEntity.ok(cartService.findById(id));
    }

    @PutMapping
    private ResponseEntity<Boolean> putUpdateCart(@RequestBody Cart updatedCart) {
        return ResponseEntity.ok(cartService.update(updatedCart));
    }

    @DeleteMapping
    private ResponseEntity<Boolean> deleteCart(@PathVariable int id) {
        return ResponseEntity.ok(cartService.delete(id));
    }

}
