package com.example.ecommerce.cart;

import com.example.ecommerce.cart.Cart;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "cart")
public record
Cart(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id,
     @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL,
                fetch = FetchType.LAZY) List<Cart> items,
     @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "parent_id")
     Cart cart) {}
