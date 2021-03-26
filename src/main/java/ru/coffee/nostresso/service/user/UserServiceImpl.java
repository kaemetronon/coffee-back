package ru.coffee.nostresso.service.user;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.coffee.nostresso.model.Role;
import ru.coffee.nostresso.model.entity.User;
import ru.coffee.nostresso.model.mapper.UserMapper;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements IUserService {

    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public Long addUser(Long id) {
        userMapper.addUser(id, Role.USER);
        return id;
    }

    @Override
    public Long addAdmin(Long id) {
        userMapper.addUser(id, Role.ADMIN);
        return id;
    }

    @Override
    public void deleteById(Long userId) {
        userMapper.deleteById(userId);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userMapper.findById(Long.parseLong(s));
    }
}
