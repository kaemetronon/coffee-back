package ru.coffee.nostresso.service.item;

import ru.coffee.nostresso.model.entity.Item;

import java.util.List;
import java.util.UUID;

public interface IItemService {

    List<Item> getAllItems();

    List<Item> getItemsByShop(UUID shopId);

    Item addItem(Item item);

    Item updateItem(Item item);

    void deleteItem(UUID itemId);
}
