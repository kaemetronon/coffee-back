package ru.coffee.nostresso.controller.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.coffee.nostresso.model.entity.Shop;
import ru.coffee.nostresso.model.entity.User;
import ru.coffee.nostresso.service.user.IUserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/admin/user")
@RequiredArgsConstructor
@Api(value = "User Controller", description = "только для админов")
public class AdminUserController {

    private final IUserService userService;

    @GetMapping("/")
    @ApiOperation(value = "Получение всех пользователей(мб кусок кода отсюда потом пригодится)",
            response = Iterable.class)
    public List<User> getUsers() {
        return userService.findAll();
    }

    @PostMapping("/")
    @ApiOperation(value = "Добавление пользователя", response = User.class)
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping("/")
    @ApiOperation(value = "Обновление данных о пользователе", response = User.class)
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/")
    public String deleteUser(@RequestParam UUID userId) {
        userService.deleteById(userId);
        return "user deleted";
    }
}

