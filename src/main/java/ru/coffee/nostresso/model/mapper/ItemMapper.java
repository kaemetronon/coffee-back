package ru.coffee.nostresso.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import ru.coffee.nostresso.model.entity.Item;

import java.util.List;

@Repository
@Mapper
public interface ItemMapper {
    List<Item> getAllItems();

    List<Item> getItemsByShop(Integer shopId);

    void addItem(Integer id, Item item);

    void updateItem(Item item);

    void deleteItem(Integer id);
}
