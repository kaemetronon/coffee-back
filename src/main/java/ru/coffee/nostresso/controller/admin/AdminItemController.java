package ru.coffee.nostresso.controller.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.coffee.nostresso.model.entity.Item;
import ru.coffee.nostresso.service.item.IItemService;

import java.util.UUID;

@RestController
@RequestMapping("/admin/item")
@RequiredArgsConstructor
@Api(value = "Item Controller", description = "только для админов")
public class AdminItemController {

    private final IItemService itemService;

    @PostMapping
    @ApiOperation(value = "Добавление предмета в кофейню", response = Item.class)
    public Item addItem(@RequestBody Item item) {
        return itemService.addItem(item);
    }

    @PutMapping
    @ApiOperation(value = "Обновление предмета в кофейне", response = Item.class)
    public Item updateItem(@RequestBody Item item) {
        return itemService.updateItem(item);
    }

    @DeleteMapping
    @ApiOperation(value = "Удаление предмета в кофейне", response = String.class)
    public String deleteItem(@RequestParam UUID itemId) {
        itemService.deleteItem(itemId);
        return "Item deleted";
    }
}
