package ru.coffee.nostresso.service.shop;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.coffee.nostresso.model.entity.Address;
import ru.coffee.nostresso.model.entity.Shop;
import ru.coffee.nostresso.model.mapper.AddressMapper;
import ru.coffee.nostresso.model.mapper.ShopMapper;

import java.util.List;
import java.util.OptionalDouble;
import java.util.Random;

@Service
@AllArgsConstructor
@Slf4j
public class ShopServiceImpl implements IShopService {

    private ShopMapper shopMapper;
    private AddressMapper addressMapper;

    @Override
    public List<Shop> findAll() {
        return shopMapper.findAll();
    }

    @Override
    public Long addShop(Shop shop) {
        var id = new Random().nextLong();
        shopMapper.addShop(id, shop);
        return id;
    }

    @Override
    public void updateShop(Shop shop) {
        shopMapper.updateShop(shop);
    }

    public void updateShopMiddleRate(Long shopId, List<Long> rates) {
        OptionalDouble rate = rates.stream().mapToLong(i -> i).average();
        if (rate.isPresent())
            shopMapper.updateShopMiddleRate(shopId, rate.getAsDouble());
    }

    @Override
    public void deleteById(Long coffeeShopId) {
        shopMapper.deleteById(coffeeShopId);
    }

    @Override
    public Address getAddress(Long shopId) {
//        non used
        return null;
    }

    @Override
    public void addNewAddress(Long shopId, Address address) {
        //        non used
    }

    @Override
    public void updateAddress(Address address) {
        addressMapper.updateAddress(address);
    }

    @Override
    public void deleteAddress(Long shopId) {
//        non used
    }
}
