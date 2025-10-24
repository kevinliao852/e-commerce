package com.example.ecommerce.cart;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

  private final CartRepository cartRepository;

  @Autowired
  public CartService(CartRepository cartRepository) {
    this.cartRepository = cartRepository;
  }

  public List<Cart> getAllCarts() { return cartRepository.findAll(); }

  public Optional<Cart> getCartById(Long id) {
    return cartRepository.findById(id);
  }

  public Cart createCart(Cart cart) { return cartRepository.save(cart); }

  // public Cart updateItem(Long id, Cart updatedCart) {
  // Optional<Cart> existingCartOptional = cartRepository.findById(id);

  // if (existingCartOptional.isPresent()) {
  // Cart existingCart = existingCartOptional.get();
  // existingCart.setName(updatedCart.getName());
  // existingCart.setPrice(updatedCart.getPrice());
  // existingCart.setQuantity(updatedCart.getQuantity());
  // return cartRepository.save(existingCart);
  // } else {
  // throw new RuntimeException("Item not found with id: " + id);
  // }
  // }

  public void deleteCart(Long id) { cartRepository.deleteById(id); }
}
