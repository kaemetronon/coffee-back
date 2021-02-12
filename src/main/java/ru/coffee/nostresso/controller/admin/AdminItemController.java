package ru.coffee.nostresso.controller.admin;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.coffee.nostresso.model.Item;
import ru.coffee.nostresso.model.response.FailResponce;
import ru.coffee.nostresso.repo.ItemRepo;

import java.util.UUID;

@RestController
@RequestMapping("/admin/item")
@AllArgsConstructor
public class AdminItemController {

    private ItemRepo itemRepo;

    @PostMapping("/")
    public Item addItem(@RequestBody Item item) {
        return item;
    }

    @PutMapping("/")
    public Item updateItem(@RequestBody Item item) {
        return item;
    }

    @DeleteMapping("/")
    public String deleteItem(@RequestBody UUID itemId) {
        return "item " + itemId + " deleted";
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<FailResponce> handle(Exception e) {
        return new ResponseEntity<>(new FailResponce(e.getMessage()), HttpStatus.valueOf(501));
    }
}
