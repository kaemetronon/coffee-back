//package ru.coffee.nostresso;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//import ru.coffee.nostresso.model.entity.Item;
//import ru.coffee.nostresso.service.item.IItemService;
//
//
//import static org.junit.Assert.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ItemServiceTest {
//
//    @Autowired
//    private IItemService itemService;
//
//    private Long itemId = 1L;
//    private Long shopId = 2L;
//
//    @Test
//    public void getAllItems() {
//        assertNotNull(itemService.getAllItems());
//    }
//
//    @Test
//    public void getItemsByShop() {
//        assertNotNull(itemService.getItemsByShop(shopId));
//    }
//
//    @Test
//    @Transactional(timeout = 7200)
//    public void addItem() {
//        var i = createItem();
//        var id = itemService.addItem(i);
//        assertEquals(1, itemService.getAllItems().stream()
//                .filter(o -> o.getId().equals(id)).count());
//    }
//
//    @Test
//    @Transactional(timeout = 7200)
//    public void updateItem() {
//        var i = createItem();
//        i.setId(itemId);
//        itemService.updateItem(i);
//        assertEquals(1, itemService.getAllItems().stream()
//                .filter(o -> o.getId().equals(i.getId()) && o.getCost().equals(i.getCost())).count());
//    }
//
//    @Test
//    @Transactional(timeout = 7200)
//    public void deleteItem() {
//        var was = itemService.getAllItems().size();
//        itemService.deleteItem(itemId);
//        var became = itemService.getAllItems().size();
//        assertEquals(1, was - became);
//    }
//
//    private Item createItem() {
//        var i = new Item();
//        i.setId(3L);
//        i.setCost(1488L);
//        i.setName("name");
//        i.setVolume("vol");
//        i.setShopId(shopId);
//        return i;
//    }
//}
