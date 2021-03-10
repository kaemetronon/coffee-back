package ru.coffee.nostresso.controller.common;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.coffee.nostresso.model.entity.Item;
import ru.coffee.nostresso.service.item.IItemService;

import java.util.List;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {

    private final IItemService itemService;

    @GetMapping("/byShop")
    public List<Item> getItemByShopId(@RequestParam Long shopId) {
        return itemService.getItemsByShop(shopId);
    }

}
