package ru.coffee.nostresso.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import ru.coffee.nostresso.model.entity.Shop;

import java.util.UUID;

@Repository
@Mapper
public interface ShopMapper {
    Iterable<Shop> findAll();

    Shop save(Shop shop);

    void deleteById(UUID coffeeShopId);
}
