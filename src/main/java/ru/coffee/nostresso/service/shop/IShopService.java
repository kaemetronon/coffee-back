package ru.coffee.nostresso.service.shop;

import ru.coffee.nostresso.model.entity.Address;
import ru.coffee.nostresso.model.entity.Shop;

import java.util.List;

public interface IShopService {
    List<Shop> findAll();

    Integer addShop(Shop shop);

    void updateShop(Shop shop);

    void deleteById(Integer shopId);

    Address getAddress(Integer shopId);

    void addNewAddress(Integer shopId, Address address);

    void updateAddress(Address address);

    void deleteAddress(Integer shopId);
}
