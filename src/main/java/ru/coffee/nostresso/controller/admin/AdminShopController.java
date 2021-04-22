package ru.coffee.nostresso.controller.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.coffee.nostresso.model.entity.Address;
import ru.coffee.nostresso.model.entity.Item;
import ru.coffee.nostresso.model.entity.Shop;
import ru.coffee.nostresso.service.shop.IShopService;

import java.util.UUID;

@RestController
@RequestMapping("/admin/shop")
@RequiredArgsConstructor
@Api(value = "Shop Controller", description = "только для админов")
public class AdminShopController {

    private final IShopService shopService;

    @PostMapping
    @ApiOperation(value = "Добавление кофейни", response = Shop.class)
    public Shop addCoffeeShop(@RequestBody Shop shop) {
        return shopService.addShop(shop);
    }

    @PutMapping
    @ApiOperation(value = "Обновление инфы о кефейне(доступно только админу конкретной кофейни)",
            response = Shop.class)
    public Shop updateCoffeeShop(@RequestBody Shop shop) {
        return shopService.updateShop(shop);
    }

    @PutMapping("/edit_addr")
    @ApiOperation(value = "Обновление инфы об адресе для кофейни", response = Address.class)
    public Address setNewAddressForShop(@RequestParam UUID shopId, @RequestBody Address address) {
        address.setShopId(shopId);
        return shopService.updateAddress(address, shopId);
    }

    @DeleteMapping
    @ApiOperation(value = "Удаление кофейни", response = Address.class)
    public String deleteCoffeeShop(@RequestParam UUID shopId) {
        shopService.deleteById(shopId);
        return "CoffeeShop deleted";
    }
}
