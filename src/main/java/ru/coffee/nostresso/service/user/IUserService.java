package ru.coffee.nostresso.service.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import ru.coffee.nostresso.model.entity.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    Long addUser(User user);

    void updateUser(User user);

    void deleteById(Long userId);
}
