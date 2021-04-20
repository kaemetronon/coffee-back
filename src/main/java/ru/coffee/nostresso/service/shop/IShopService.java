package ru.coffee.nostresso.service.shop;

import ru.coffee.nostresso.model.entity.Address;
import ru.coffee.nostresso.model.entity.Shop;

import java.util.List;
import java.util.UUID;

public interface IShopService {
    List<Shop> findAll();

    Shop addShop(Shop shop);

    Shop updateShop(Shop shop);

    void deleteById(UUID shopId);

    Address getAddress(UUID shopId);

    void addNewAddress(UUID shopId, Address address);

    Address updateAddress(Address address, UUID shopId);

    void deleteAddress(UUID shopId);
}
