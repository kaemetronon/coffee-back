package ru.coffee.nostresso.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import ru.coffee.nostresso.model.entity.Shop;

import java.util.List;

@Repository
@Mapper
public interface ShopMapper {
    List<Shop> findAll();

    void addShop(Integer id, Shop shop);

    void updateShop(Shop shop);

    void updateShopMiddleRate(Integer shopId, Double rate);

    void deleteById(Integer coffeeShopId);
}