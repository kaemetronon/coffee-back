package ru.coffee.nostresso.controller.admin;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.coffee.nostresso.model.entity.Shop;
import ru.coffee.nostresso.model.mapper.ShopMapper;

import java.util.UUID;

@RestController
@RequestMapping("/admin/shop")
@AllArgsConstructor
public class AdminShopController {

    private final ShopMapper shopRepo;

    @GetMapping("/")
    public Iterable<Shop> getAllCoffeeShops() {
        return shopRepo.findAll();
    }

    @PostMapping("/")
    public Shop addCoffeeShop(@RequestBody Shop shop) {
        return shopRepo.save(shop);
    }


    @PutMapping("/")
    public Shop updateCoffeeShop(@RequestBody Shop shop) {
            return shopRepo.save(shop);
    }

    @DeleteMapping("/")
    public String deleteCoffeeShop(@RequestParam UUID coffeeShopId) {
        shopRepo.deleteById(coffeeShopId);
        return "CoffeeShop " + coffeeShopId + " deleted";
    }
}
