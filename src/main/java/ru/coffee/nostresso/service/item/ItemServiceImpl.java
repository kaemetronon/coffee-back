package ru.coffee.nostresso.service.item;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.coffee.nostresso.model.entity.Item;
import ru.coffee.nostresso.model.mapper.ItemMapper;

import java.util.List;
import java.util.Random;

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
    public List<Item> getItemsByShop(Integer shopId) {
        return itemMapper.getItemsByShop(shopId);
    }

    @Override
    public Integer addItem(Item item) {
        var id = new Random().nextInt(1_000_000);
        itemMapper.addItem(id, item);
        return id;
    }

    @Override
    public void updateItem(Item item) {
        itemMapper.updateItem(item);
    }

    @Override
    public void deleteItem(Integer itemId) {
        itemMapper.deleteItem(itemId);
    }
}
