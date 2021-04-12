package ru.coffee.nostresso.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import ru.coffee.nostresso.model.entity.User;

import java.util.List;
import java.util.UUID;

@Repository
@Mapper
public interface UserMapper {
    List<User> findAllUsers();

    void addUser(UUID id, User user);

    void updateUser(User user);

    void deleteUserById(UUID userId);
}
