package com.example.ecommerce.item;
import com.example.ecommerce.item.Item;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ecommerce.item.ItemRepository;

@Service
public class ItemService {

  private final ItemRepository itemRepository;

  @Autowired
  public ItemService(ItemRepository itemRepository) {
    this.itemRepository = itemRepository;
  }

  public List<Item> getAllItems() { return itemRepository.findAll(); }

  public Optional<Item> getItemById(Long id) {
    return itemRepository.findById(id);
  }

  public Item createItem(Item item) { return itemRepository.save(item); }

  public Item updateItem(Long id, Item updatedItem) {
    Optional<Item> existingItemOptional = itemRepository.findById(id);

    if (existingItemOptional.isPresent()) {
      Item existingItem = existingItemOptional.get();
      existingItem.setName(updatedItem.getName());
      existingItem.setPrice(updatedItem.getPrice());
      existingItem.setQuantity(updatedItem.getQuantity());
      return itemRepository.save(existingItem);
    } else {
      // Handle not found scenario, throw exception or return a specific
      // response
      throw new RuntimeException("Item not found with id: " + id);
    }
  }

  public void deleteItem(Long id) { itemRepository.deleteById(id); }
}
