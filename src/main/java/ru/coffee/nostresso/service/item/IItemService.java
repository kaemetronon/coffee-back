package ru.coffee.nostresso.service.item;

import ru.coffee.nostresso.model.entity.Item;

import java.util.List;
import java.util.UUID;

public interface IItemService {

    List<Item> getAllItems();

    List<Item> getItemsByShop(UUID shopId);

    UUID addItem(Item item);

    void updateItem(Item item);

    void deleteItem(UUID itemId);
}
