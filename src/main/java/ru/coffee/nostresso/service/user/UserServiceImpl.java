package ru.coffee.nostresso.service.user;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.coffee.nostresso.model.entity.User;
import ru.coffee.nostresso.model.mapper.UserMapper;

import java.util.List;
import java.util.Random;

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
    public Integer addUser(User user) {
        var id = new Random().nextInt(1_000_000);
        userMapper.addUser(id, user);
        return id;
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void deleteById(Integer userId) {
        userMapper.deleteById(userId);
    }
}
