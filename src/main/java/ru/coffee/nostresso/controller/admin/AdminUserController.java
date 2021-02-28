package ru.coffee.nostresso.controller.admin;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.coffee.nostresso.model.entity.User;
import ru.coffee.nostresso.model.mapper.UserMapper;

import java.util.UUID;

@RestController
@RequestMapping("/admin/user")
@AllArgsConstructor
public class AdminUserController {

    private final UserMapper userRepo;

    @GetMapping("/")
    public Iterable<User> getUsers() {
        return userRepo.findAll();
    }

    @PostMapping("/")
    public User addUser(@RequestBody User user) {
        return userRepo.save(user);
    }

    @PutMapping("/")
    public User updateUser(@RequestBody User user) {
            return userRepo.save(user);
    }

    @DeleteMapping("/")
    public String deleteUser(@RequestParam UUID userId) {
        userRepo.deleteById(userId);
        return "user " + userId + " deleted";
    }
}

