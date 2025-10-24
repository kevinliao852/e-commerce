package com.example.ecommerce.cart;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/carts")
@RestController
public class CartController {

  private final CartService cartService;

  @Autowired
  public CartController(CartService cartService) {
    this.cartService = cartService;
  }

  @GetMapping
  public ResponseEntity<List<Cart>> getAllCarts() {
    List<Cart> carts = cartService.getAllCarts();
    return new ResponseEntity<>(carts, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Cart> getCartById(@PathVariable Long id) {
    return cartService.getCartById(id)
        .map(cart -> new ResponseEntity<>(cart, HttpStatus.OK))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping
  public ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
    Cart createdCart = cartService.createCart(cart);
    return new ResponseEntity<>(createdCart, HttpStatus.CREATED);
  }

  // @PutMapping("/{id}")
  // public ResponseEntity<Cart> updateItem(@PathVariable Long id,
  // @RequestBody Cart updatedItem) {
  // Cart updated = cartService.updateItem(id, updatedItem);
  // return new ResponseEntity<>(updated, HttpStatus.OK);
  // }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
    try {
      cartService.deleteCart(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
