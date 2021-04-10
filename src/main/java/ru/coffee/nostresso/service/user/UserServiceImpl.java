package ru.coffee.nostresso.service.user;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.coffee.nostresso.model.entity.User;
import ru.coffee.nostresso.model.mapper.UserMapper;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements IUserService {

    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAllUsers();
    }

    @Override
    public UUID addUser(User user) {
        var id = UUID.randomUUID();
        userMapper.addUser(id, user);
        return id;
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void deleteById(UUID userId) {
        userMapper.deleteById(userId);
    }
}
