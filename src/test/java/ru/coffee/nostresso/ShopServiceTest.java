package ru.coffee.nostresso;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.coffee.nostresso.model.entity.Shop;
import ru.coffee.nostresso.service.shop.ShopServiceImpl;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopServiceTest {

    @Autowired
    private ShopServiceImpl shopService;

    private Integer shopId = 2;

    @Test
    public void findAllShops() {
        assertNotNull(shopService.findAll());
    }

    @Test
    @Transactional(timeout = 7200)
    public void addShop() {
        var i = createItem();
        var id = shopService.addShop(i);
        assertEquals(1, shopService.findAll().stream()
                .filter(o -> o.getId().equals(id)).count());
    }

    @Test
    @Transactional(timeout = 7200)
    public void updateItem() {
        var i = createItem();
        i.setId(shopId);
        shopService.updateShop(i);
        assertEquals(1, shopService.findAll().stream()
                .filter(o -> o.getId().equals(i.getId()) && o.getName().equals(i.getName())).count());
    }

    @Test
    @Transactional(timeout = 7200)
    public void updateMiddleRate() {
        shopService.updateShopMiddleRate(shopId, Arrays.asList(1, 2, 3, 4));
        shopService.findAll().stream().filter(o -> o.getId().equals(shopId))
                .findFirst().ifPresent(o -> assertEquals(Double.valueOf(2.5), o.getMiddleRate()));
    }

    @Test
    @Transactional(timeout = 7200)
    public void deleteItem() {
        var was = shopService.findAll().size();
        shopService.deleteById(shopId);
        var became = shopService.findAll().size();
        assertEquals(1, was - became);
    }

    private Shop createItem() {
        var i = new Shop();
        i.setId(4);
        i.setName("name");
        i.setDescription("dscr");
        i.setPhone("+7911");
        i.setImg("img");
        i.setMiddleRate(55.55D);
        return i;
    }
}
