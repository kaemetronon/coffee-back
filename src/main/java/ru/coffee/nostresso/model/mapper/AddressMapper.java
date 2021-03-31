package ru.coffee.nostresso.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import ru.coffee.nostresso.model.entity.Address;

import java.util.UUID;

@Repository
@Mapper
public interface AddressMapper {

    Address getByShopId(UUID shopId);

    void updateAddress(Address a);

    void deleteByShopId(UUID shopId);
}
