package ru.coffee.nostresso.service.item;

import ru.coffee.nostresso.model.entity.Item;

import java.util.List;

public interface IItemService {

    List<Item> getAllItems();

    List<Item> getItemsByShop(Long shopId);

    Long addItem(Item item);

    void updateItem(Item item);

    void deleteItem(Long itemId);
}
