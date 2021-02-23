package ru.coffee.nostresso.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.coffee.nostresso.model.Shop;
import ru.coffee.nostresso.model.OrderHistory;
import ru.coffee.nostresso.model.Item;
import ru.coffee.nostresso.repo.ShopRepo;
import ru.coffee.nostresso.repo.HistoryRepo;
import ru.coffee.nostresso.repo.ItemRepo;
import ru.coffee.nostresso.repo.UserRepo;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/")
@AllArgsConstructor
@Api(value = "main controller")
public class Controller {

    private final ShopRepo shopRepo;
    private final ItemRepo itemRepo;
    private final UserRepo userRepo;
    private final HistoryRepo historyRepo;

    @GetMapping("/coffees")
    @ApiOperation(value = "get all coffees", response = Shop[].class)
    public Iterable<Shop> getAllCoffeeshops() {
        return shopRepo.findAll();
    }

    @GetMapping("/shop")
    @ApiOperation(value = "get items by coffeeshop", response = Item[].class)
    public Iterable<Item> getItemsFromCoffeeShop(@RequestParam UUID shopId) {
        return itemRepo.findByShopId(shopId);
    }

    @GetMapping("/history")
    @ApiOperation(value = "get all history", response = OrderHistory[].class)
    public Optional<OrderHistory> getHistory(@RequestParam UUID userId) {
        return historyRepo.findByUserId(userId);
    }
}
