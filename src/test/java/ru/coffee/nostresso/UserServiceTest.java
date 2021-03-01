package ru.coffee.nostresso;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.coffee.nostresso.model.entity.User;
import ru.coffee.nostresso.service.user.IUserService;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private IUserService userService;

    private UUID userId = UUID.fromString("91aa5dc1-2919-43bc-9867-30ac11108bb7");

    @Test
    public void findAllShops() {
        assertNotNull(userService.findAll());
    }

    @Test
    @Transactional(timeout = 7200)
    public void addShop() {
        var i = createItem();
        var id = userService.addUser(i);
        assertEquals(1, userService.findAll().stream()
                .filter(o -> o.getId().equals(id)).count());
    }

    @Test
    @Transactional(timeout = 7200)
    public void updateItem() {
        var i = createItem();
        i.setId(userId);
        userService.updateUser(i);
        assertEquals(1, userService.findAll().stream()
                .filter(o -> o.getId().equals(i.getId()) && o.getName().equals(i.getName())).count());
    }

    @Test
    @Transactional(timeout = 7200)
    public void deleteItem() {
        var was = userService.findAll().size();
        userService.deleteById(userId);
        var became = userService.findAll().size();
        assertEquals(1, was - became);
    }

    private User createItem() {
        var i = new User();
        i.setId(UUID.randomUUID());
        i.setName("name");
        return i;
    }
}
