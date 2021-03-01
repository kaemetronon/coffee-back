package ru.coffee.nostresso.service.shop;

import ru.coffee.nostresso.model.entity.Shop;

import java.util.UUID;

public interface IShopService {
    Iterable<Shop> findAll();

    UUID addShop(Shop shop);

    void updateShop(Shop shop);

    void deleteById(UUID coffeeShopId);
}
