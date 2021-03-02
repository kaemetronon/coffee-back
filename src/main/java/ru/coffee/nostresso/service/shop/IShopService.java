package ru.coffee.nostresso.service.shop;

import ru.coffee.nostresso.model.entity.Address;
import ru.coffee.nostresso.model.entity.Shop;

import java.util.UUID;
import java.util.List;

public interface IShopService {
    List<Shop> findAll();

    UUID addShop(Shop shop);

    void updateShop(Shop shop);

    void deleteById(UUID shopId);

    Address getAddress(UUID shopId);

    void addNewAddress(UUID shopId, Address address);

    void updateAddress(Address address);

    void deleteAddress(UUID shopId);
}
