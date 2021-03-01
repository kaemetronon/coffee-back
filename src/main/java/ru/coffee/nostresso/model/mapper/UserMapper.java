package ru.coffee.nostresso.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import ru.coffee.nostresso.model.entity.User;

import java.util.UUID;

@Repository
@Mapper
public interface UserMapper {
    Iterable<User> findAll();

    UUID addUser(UUID id, User user);

    void updateUser(User user);

    void deleteById(UUID userId);
}
