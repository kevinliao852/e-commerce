package com.example.ecommerce.item;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.ecommerce.item.ItemService;
import com.example.ecommerce.item.Item;

@RequestMapping("/items")
@RestController
public class ItemController {

  private final ItemService itemService;

  @Autowired
  public ItemController(ItemService itemService) {
    this.itemService = itemService;
  }

  @GetMapping
  public ResponseEntity<List<Item>> getAllItems() {
    List<Item> items = itemService.getAllItems();
    return new ResponseEntity<>(items, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Item> getItemById(@PathVariable Long id) {
    return itemService.getItemById(id)
        .map(item -> new ResponseEntity<>(item, HttpStatus.OK))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping
  public ResponseEntity<Item> createItem(@RequestBody Item item) {
    Item createdItem = itemService.createItem(item);
    return new ResponseEntity<>(createdItem, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Item> updateItem(@PathVariable Long id,
                                         @RequestBody Item updatedItem) {
    Item updated = itemService.updateItem(id, updatedItem);
    return new ResponseEntity<>(updated, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
    try {
      itemService.deleteItem(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
