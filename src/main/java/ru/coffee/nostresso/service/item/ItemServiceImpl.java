package ru.coffee.nostresso.service.item;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.coffee.nostresso.model.entity.Item;
import ru.coffee.nostresso.model.mapper.ItemMapper;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class ItemServiceImpl implements IItemService{

    private ItemMapper itemMapper;

    @Override
    public Iterable<Item> getAllItems() {
        return itemMapper.getAllItems();
    }

    @Override
    public Iterable<Item> getItemsByShop(UUID shopId) {
        return itemMapper.getItemsByShop(shopId);
    }

    @Override
    public UUID addItem(Item item) {
        var id = UUID.randomUUID();
        itemMapper.addItem(id, item);
        return id;
    }

    @Override
    public void updateItem(Item item) {
        itemMapper.updateItem(item);
    }

    @Override
    public void deleteItem(UUID itemId) {
        itemMapper.deleteItem(itemId);
    }


}
