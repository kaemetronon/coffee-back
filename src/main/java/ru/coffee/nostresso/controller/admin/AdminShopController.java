package ru.coffee.nostresso.controller.admin;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.coffee.nostresso.model.entity.Address;
import ru.coffee.nostresso.model.entity.Shop;
import ru.coffee.nostresso.service.shop.IShopService;

import java.util.UUID;
import java.util.List;

@RestController
@RequestMapping("/admin/shop")
@AllArgsConstructor
public class AdminShopController {

    private final IShopService shopService;

    @GetMapping
    public List<Shop> getAllCoffeeShops() {
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

    @PutMapping("/edit_addr")
    public String setNewAddressForShop(@RequestParam UUID shopId, @RequestBody Address address) {
        address.setShopId(shopId);
        shopService.updateAddress(address);
        return "Address updated";
    }

    @DeleteMapping
    public String deleteCoffeeShop(@RequestParam UUID shopId) {
        shopService.deleteById(shopId);
        return "CoffeeShop " + shopId + " deleted";
    }
}
