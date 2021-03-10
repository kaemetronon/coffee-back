package ru.coffee.nostresso.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import ru.coffee.nostresso.model.entity.Shop;

import java.util.List;

@Repository
@Mapper
public interface ShopMapper {
    List<Shop> findAll();

    void addShop(Long id, Shop shop);

    void updateShop(Shop shop);

    void updateShopMiddleRate(Long shopId, Double rate);

    void deleteById(Long coffeeShopId);
}