package ru.coffee.nostresso.controller.common;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.coffee.nostresso.model.entity.Shop;
import ru.coffee.nostresso.service.shop.IShopService;

import java.util.List;

@RestController
@RequestMapping("/shop")
@AllArgsConstructor
public class ShopsController {

    private final IShopService shopService;

    @GetMapping
    public List<Shop> getAllCoffeeShops() {
        return shopService.findAll();
    }
}
