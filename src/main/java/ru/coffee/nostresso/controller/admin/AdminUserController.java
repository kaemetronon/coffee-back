package ru.coffee.nostresso.controller.admin;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.coffee.nostresso.model.User;
import ru.coffee.nostresso.model.response.FailResponce;
import ru.coffee.nostresso.repo.UserRepo;

import java.util.UUID;

@RestController
@RequestMapping("/admin/user")
@AllArgsConstructor
public class AdminUserController {

    private final UserRepo userRepo;

    @PostMapping("/")
    public User addUser(@RequestBody User user) {
        return user;
    }

    @PutMapping("/")
    public User updateUser(@RequestBody User user) {
        return user;
    }

    @DeleteMapping("/")
    public String deleteUser(@RequestBody UUID userId) {
        return "user " + userId + " deleted";
    }
}

