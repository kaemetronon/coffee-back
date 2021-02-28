package ru.coffee.nostresso.controller.admin;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.coffee.nostresso.model.entity.Item;
import ru.coffee.nostresso.model.mapper.ItemMapper;
import ru.coffee.nostresso.service.item.IItemService;

import java.util.UUID;

@RestController
@RequestMapping("/admin/item")
@AllArgsConstructor
public class AdminItemController {

    private final IItemService itemService;

    @GetMapping
    public Iterable<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/byShop")
    public Iterable<Item> getItemByShopId(@RequestParam UUID shopId) {
        return itemService.getItemsByShop(shopId);
    }

    @PostMapping
    public UUID addItem(@RequestBody Item item) {
        return itemService.addItem(item);
    }

    @PutMapping
    public String updateItem(@RequestBody Item item) {
        itemService.updateItem(item);
        return "item updated";
    }

    @DeleteMapping
    public String deleteItem(@RequestParam UUID itemId) {
        itemService.deleteItem(itemId);
        return "item " + itemId + " deleted";
    }
}
