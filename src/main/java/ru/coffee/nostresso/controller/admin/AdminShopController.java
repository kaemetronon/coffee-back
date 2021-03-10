package ru.coffee.nostresso.controller.admin;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.coffee.nostresso.model.entity.Address;
import ru.coffee.nostresso.model.entity.Shop;
import ru.coffee.nostresso.service.shop.IShopService;

@RestController
@RequestMapping("/admin/shop")
@AllArgsConstructor
public class AdminShopController {

    private final IShopService shopService;

    @PostMapping
    public Long addCoffeeShop(@RequestBody Shop shop) {
        return shopService.addShop(shop);
    }

    @PutMapping
    public String updateCoffeeShop(@RequestBody Shop shop) {
        shopService.updateShop(shop);
        return "Shop updated";
    }

    @PutMapping("/edit_addr")
    public String setNewAddressForShop(@RequestParam Long shopId, @RequestBody Address address) {
        address.setShopId(shopId);
        shopService.updateAddress(address);
        return "Address updated";
    }

    @DeleteMapping
    public String deleteCoffeeShop(@RequestParam Long shopId) {
        shopService.deleteById(shopId);
        return "CoffeeShop " + shopId + " deleted";
    }
}
