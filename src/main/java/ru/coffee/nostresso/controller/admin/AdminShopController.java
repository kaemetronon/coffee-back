package ru.coffee.nostresso.controller.admin;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.coffee.nostresso.model.CoffeeShop;
import ru.coffee.nostresso.model.response.FailResponce;
import ru.coffee.nostresso.repo.CoffeeShopRepo;

import java.util.UUID;

@RestController
@RequestMapping("/admin/shop")
@AllArgsConstructor
public class AdminShopController {

    private CoffeeShopRepo coffeeShopRepo;

    @PostMapping("/")
    public CoffeeShop addShop(@RequestBody CoffeeShop coffeeShop) {
        return coffeeShop;
    }

    @PutMapping("/")
    public CoffeeShop updateShop(@RequestBody CoffeeShop coffeeShop) {
        return coffeeShop;
    }

    @DeleteMapping("/")
    public String deleteShop(@RequestBody UUID shopId) {
        return "coffeeshop " + shopId + " deleted";
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<FailResponce> handle(Exception e) {
        return new ResponseEntity<>(new FailResponce(e.getMessage()), HttpStatus.valueOf(501));
    }
}
