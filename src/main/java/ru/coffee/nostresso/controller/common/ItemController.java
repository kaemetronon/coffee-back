package ru.coffee.nostresso.controller.common;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.coffee.nostresso.model.entity.Item;
import ru.coffee.nostresso.model.entity.User;
import ru.coffee.nostresso.service.item.IItemService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
@Api(value = "User Controller", description = "доступен всем")
public class ItemController {

    private final IItemService itemService;

    @GetMapping("/byShop")
    @ApiOperation(value = "Получение списка айтемов по конкретному шопу", response = Iterable.class)
    public List<Item> getItemByShopId(@RequestParam UUID shopId) {
        return itemService.getItemsByShop(shopId);
    }
}
