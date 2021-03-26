package ru.coffee.nostresso.service.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import ru.coffee.nostresso.model.entity.User;

import java.util.List;

public interface IUserService extends UserDetailsService{
    List<User> findAll();

    Long addUser(Long id);

    Long addAdmin(Long id);


    void deleteById(Long userId);

    UserDetails loadUserByUsername(String s);
}
