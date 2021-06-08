package ru.coffee.nostresso.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import ru.coffee.nostresso.model.entity.AdminUser;

@Repository
@Mapper
public interface AdminUserMapper {
    AdminUser findByUsername(String username);
}
