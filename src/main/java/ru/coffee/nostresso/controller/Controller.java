package ru.coffee.nostresso.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.coffee.nostresso.model.CoffeeShop;
import ru.coffee.nostresso.model.History;
import ru.coffee.nostresso.model.Item;
import ru.coffee.nostresso.repo.CoffeeShopRepo;
import ru.coffee.nostresso.repo.HistoryRepo;
import ru.coffee.nostresso.repo.ItemRepo;
import ru.coffee.nostresso.repo.UserRepo;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class Controller {

    private final CoffeeShopRepo coffeeShopRepo;
    private final ItemRepo itemRepo;
    private final UserRepo userRepo;
    private final HistoryRepo historyRepo;

    @GetMapping("/coffees")
    public Iterable<CoffeeShop> getAllCoffeeshops() {
        return coffeeShopRepo.findAll();
    }

    @GetMapping("/shop")
    public Iterable<Item> getItemsFromCoffeeShop(@RequestParam UUID shopId) {
        return itemRepo.findByShopId(shopId);
    }

    @GetMapping("/history")
    public Optional<History> getHistory(@RequestParam UUID userId) {
        return historyRepo.findByUserId(userId);
    }
}
