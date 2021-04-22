package ru.coffee.nostresso.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import ru.coffee.nostresso.model.entity.Item;

import java.util.List;
import java.util.UUID;

@Repository
@Mapper
public interface ItemMapper {
    List<Item> getAllItems();

    List<Item> getItemsByShop(UUID shopId);

    void addItem(UUID id, Item item);

    void updateItem(Item item);

    void deleteItem(UUID id);

    Item getItemById(UUID id);
}
