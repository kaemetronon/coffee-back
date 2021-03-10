package ru.coffee.nostresso.controller.admin;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.coffee.nostresso.model.entity.Item;
import ru.coffee.nostresso.service.item.IItemService;

import java.util.List;

@RestController
@RequestMapping("/admin/item")
@AllArgsConstructor
public class AdminItemController {

    private final IItemService itemService;

    @PostMapping
    public Long addItem(@RequestBody Item item) {
        return itemService.addItem(item);
    }

    @PutMapping
    public String updateItem(@RequestBody Item item) {
        itemService.updateItem(item);
        return "item updated";
    }

    @DeleteMapping
    public String deleteItem(@RequestParam Long itemId) {
        itemService.deleteItem(itemId);
        return "item " + itemId + " deleted";
    }
}
