package ru.coffee.nostresso.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.coffee.nostresso.model.CoffeeShop;
import ru.coffee.nostresso.repo.CoffeeShopRepo;

import java.util.Optional;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class Controller {

    private final CoffeeShopRepo coffeeShopRepo;

    @GetMapping("/coffees")
    public Iterable<CoffeeShop> getAllCoffeeshops() {
        return coffeeShopRepo.findAll();
    }

    @GetMapping("/items/{coffeeShopId}")
    public Optional<CoffeeShop> getItemsFromCoffeeShop(@PathVariable Integer coffeeShopId) {
        return coffeeShopRepo.findById(coffeeShopId);
    }
}
