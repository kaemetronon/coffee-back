package ru.coffee.nostresso.controller.admin;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.coffee.nostresso.model.User;
import ru.coffee.nostresso.repo.UserRepo;

import java.util.UUID;

@RestController
@RequestMapping("/admin/user")
@AllArgsConstructor
public class AdminUserController {

    private final UserRepo userRepo;

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
        if (userRepo.existsById(user.getId()))
            return userRepo.save(user);
        else
            throw new RuntimeException("there is not passed id");
    }

    @DeleteMapping("/")
    public String deleteUser(@RequestParam UUID userId) {
        userRepo.deleteById(userId);
        return "user " + userId + " deleted";
    }
}

