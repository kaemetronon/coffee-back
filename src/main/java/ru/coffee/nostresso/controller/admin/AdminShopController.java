package ru.coffee.nostresso.controller.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.coffee.nostresso.model.entity.Address;
import ru.coffee.nostresso.model.entity.Shop;
import ru.coffee.nostresso.service.shop.IShopService;

import java.util.UUID;

@RestController
@RequestMapping("/admin/shop")
@RequiredArgsConstructor
public class AdminShopController {

    private final IShopService shopService;

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
