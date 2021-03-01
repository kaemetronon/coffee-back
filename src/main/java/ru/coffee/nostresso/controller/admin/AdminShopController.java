package ru.coffee.nostresso.controller.admin;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.coffee.nostresso.model.entity.Shop;
import ru.coffee.nostresso.service.shop.IShopService;

import java.util.UUID;

@RestController
@RequestMapping("/admin/shop")
@AllArgsConstructor
public class AdminShopController {

    private final IShopService shopService;

    @GetMapping
    public Iterable<Shop> getAllCoffeeShops() {
        return shopService.findAll();
    }

    @PostMapping
    public UUID addCoffeeShop(@RequestBody Shop shop) {
        return shopService.addShop(shop);
    }


    @PutMapping
    public String updateCoffeeShop(@RequestBody Shop shop) {
        shopService.updateShop(shop);
        return "Shop updated";
    }

    @DeleteMapping
    public String deleteCoffeeShop(@RequestParam UUID coffeeShopId) {
        shopService.deleteById(coffeeShopId);
        return "CoffeeShop " + coffeeShopId + " deleted";
    }
}
