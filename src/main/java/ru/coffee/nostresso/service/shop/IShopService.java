package ru.coffee.nostresso.service.shop;

import ru.coffee.nostresso.model.entity.Address;
import ru.coffee.nostresso.model.entity.Shop;

import java.util.List;

public interface IShopService {
    List<Shop> findAll();

    Long addShop(Shop shop);

    void updateShop(Shop shop);

    void deleteById(Long shopId);

    Address getAddress(Long shopId);

    void addNewAddress(Long shopId, Address address);

    void updateAddress(Address address);

    void deleteAddress(Long shopId);
}
