package ru.coffee.nostresso.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.coffee.nostresso.model.entity.Item;
import ru.coffee.nostresso.model.entity.OrderHistory;
import ru.coffee.nostresso.model.entity.Shop;
import ru.coffee.nostresso.model.mapper.ItemMapper;
import ru.coffee.nostresso.model.mapper.OrderHistoryMapper;
import ru.coffee.nostresso.model.mapper.ShopMapper;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/")
@AllArgsConstructor
@Api(value = "main controller")
public class Controller {

    private ShopMapper shopRepo;
    private ItemMapper itemRepo;
    private OrderHistoryMapper historyRepo;

    @GetMapping("/coffees")
    @ApiOperation(value = "get all coffees", response = Shop[].class)
    public Iterable<Shop> getAllCoffeeshops() {
        return shopRepo.findAll();
    }

    @GetMapping("/shop")
    @ApiOperation(value = "get items by coffeeshop", response = Item[].class)
    public Iterable<Item> getItemsFromCoffeeShop(@RequestParam UUID shopId) {
        return itemRepo.getItemsByShop(shopId);
    }

    @GetMapping("/history")
    @ApiOperation(value = "get all history", response = OrderHistory[].class)
    public Optional<OrderHistory> getHistory(@RequestParam UUID userId) {
        return historyRepo.findByUserId(userId);
    }
}
