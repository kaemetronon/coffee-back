package ru.coffee.nostresso.service.user;

import ru.coffee.nostresso.model.entity.User;

import java.util.List;
import java.util.UUID;

public interface IUserService {
    List<User> findAll();

    User addUser(User user);

    User updateUser(User user);

    void deleteById(UUID userId);
}
