package ru.coffee.nostresso.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import ru.coffee.nostresso.model.entity.User;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    List<User> findAll();

    void addUser(Long id, User user);

    void updateUser(User user);

    void deleteById(Long userId);
}
