package com.example.ecommerce.item;

import com.example.ecommerce.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
  // You can add custom query methods if needed
}
