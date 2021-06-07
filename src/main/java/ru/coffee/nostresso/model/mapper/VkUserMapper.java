package ru.coffee.nostresso.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import ru.coffee.nostresso.model.entity.Item;
import ru.coffee.nostresso.model.entity.VkUser;

import java.util.List;
import java.util.UUID;

@Repository
@Mapper
public interface VkUserMapper {

    VkUser findByVkId(Long id);

    void saveVkUser(VkUser user);
}
