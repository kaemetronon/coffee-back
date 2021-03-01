package ru.coffee.nostresso.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import ru.coffee.nostresso.model.entity.Shop;

import java.util.List;
import java.util.UUID;

@Repository
@Mapper
public interface ShopMapper {
    List<Shop> findAll();

    void addShop(UUID id, Shop shop);

    void updateShop(Shop shop);

    void updateShopMiddleRate(UUID shopId, Double rate);

    void deleteById(UUID coffeeShopId);
}