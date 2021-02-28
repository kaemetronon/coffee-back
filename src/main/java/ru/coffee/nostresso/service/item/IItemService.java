package ru.coffee.nostresso.service.item;

import ru.coffee.nostresso.model.entity.Item;

import java.util.UUID;

public interface IItemService {

    Iterable<Item> getAllItems();

    Iterable<Item> getItemsByShop(UUID shopId);

    UUID addItem(Item item);

    void updateItem(Item item);

    void deleteItem(UUID itemId);


}
