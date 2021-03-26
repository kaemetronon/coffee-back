package ru.coffee.nostresso.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import ru.coffee.nostresso.model.Role;
import ru.coffee.nostresso.model.entity.User;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    List<User> findAll();

    User findById(Long id);

    void addUser(Long id, Role role);

    void deleteById(Long userId);
}
