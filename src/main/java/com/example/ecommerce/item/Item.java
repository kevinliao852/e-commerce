package com.example.ecommerce.item;

import com.example.ecommerce.cart.Cart;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Item {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

  private String name;
  private double price;
  private int quantity;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "cart_id")
  private Cart cart;

  // Constructors, getters, and setters

  public Item() {
    // Default constructor required by JPA
  }

  public Item(String name, double price, int quantity) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }

  // Getter and Setter methods

  public Long getId() { return id; }

  public void setId(Long id) { this.id = id; }

  public String getName() { return name; }

  public void setName(String name) { this.name = name; }

  public double getPrice() { return price; }

  public void setPrice(double price) { this.price = price; }

  public int getQuantity() { return quantity; }

  public void setQuantity(int quantity) { this.quantity = quantity; }

  // toString, equals, hashCode methods (optional, but recommended for entities)
}
