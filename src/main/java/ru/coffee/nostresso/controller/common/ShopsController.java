package ru.coffee.nostresso.controller.common;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.coffee.nostresso.model.entity.Shop;
import ru.coffee.nostresso.service.shop.IShopService;

import java.util.List;

@RestController
@RequestMapping("/shop")
@RequiredArgsConstructor
@Api(value = "Shops Controller", description = "доступен всем")
public class ShopsController {

    private final IShopService shopService;

    @GetMapping("/all")
    @ApiOperation(value = "Получение списка всех кофеен", response = Iterable.class)
    public List<Shop> getAllCoffeeShops() {
        return shopService.findAll();
    }
}
