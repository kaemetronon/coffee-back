package ru.coffee.nostresso.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import ru.coffee.nostresso.model.entity.Address;

@Repository
@Mapper
public interface AddressMapper {

    Address getByShopId(Integer shopId);

    void updateAddress(Address a);

    void deleteByShopId(Integer shopId);
}
