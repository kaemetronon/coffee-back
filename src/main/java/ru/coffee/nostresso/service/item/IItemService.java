package ru.coffee.nostresso.service.item;

import ru.coffee.nostresso.model.entity.Item;

import java.util.List;

public interface IItemService {

    List<Item> getAllItems();

    List<Item> getItemsByShop(Integer shopId);

    Integer addItem(Item item);

    void updateItem(Item item);

    void deleteItem(Integer itemId);
}
