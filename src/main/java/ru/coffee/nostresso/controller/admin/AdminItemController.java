package ru.coffee.nostresso.controller.admin;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.coffee.nostresso.model.Item;
import ru.coffee.nostresso.repo.ItemRepo;

import java.util.UUID;

@RestController
@RequestMapping("/admin/item")
@AllArgsConstructor
public class AdminItemController {

    private final ItemRepo itemRepo;

    @GetMapping
    public Iterable<Item> getAllItems() {
        return itemRepo.findAll();
    }

    @PostMapping("/")
    public Item addItem(@RequestBody Item item) {
        return itemRepo.save(item);
    }


    @PutMapping("/")
    public Item updateItem(@RequestBody Item item) {
        if (itemRepo.existsById(item.getId()))
            return itemRepo.save(item);
        else
            throw new RuntimeException("there is not passed id");
    }

    @DeleteMapping("/")
    public String deleteItem(@RequestParam UUID itemId) {
        itemRepo.deleteById(itemId);
        return "item " + itemId + " deleted";
    }
}
