package com.example.ecommerce.item;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemService {
  @GetMapping("/item")
  public List<Item> getItems() {
    return List.of(new Item(1L, "apple", 1.5));
  }
}
