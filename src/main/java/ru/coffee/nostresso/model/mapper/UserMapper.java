package ru.coffee.nostresso.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import ru.coffee.nostresso.model.entity.User;

import java.util.UUID;
import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    List<User> findAll();

    void addUser(UUID id, User user);

    void updateUser(User user);

    void deleteById(UUID userId);
}
