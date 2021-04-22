package ru.coffee.nostresso.service.item;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.coffee.nostresso.model.entity.Item;
import ru.coffee.nostresso.model.mapper.ItemMapper;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class ItemServiceImpl implements IItemService {

    private ItemMapper itemMapper;

    @Override
    public List<Item> getAllItems() {
        return itemMapper.getAllItems();
    }

    @Override
    public List<Item> getItemsByShop(UUID shopId) {
        return itemMapper.getItemsByShop(shopId);
    }

    @Override
    public Item addItem(Item item) {
        var id = UUID.randomUUID();
        itemMapper.addItem(id, item);
        return itemMapper.getItemById(id);
    }

    @Override
    public Item updateItem(Item item) {
        // TODO check if not exists
        itemMapper.updateItem(item);
        return itemMapper.getItemById(item.getId());
    }

    @Override
    public void deleteItem(UUID itemId) {
        // TODO check if not exists
        itemMapper.deleteItem(itemId);
    }
}
