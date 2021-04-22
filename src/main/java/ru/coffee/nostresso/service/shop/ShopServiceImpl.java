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
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class ShopServiceImpl implements IShopService {

    private ShopMapper shopMapper;
    private AddressMapper addressMapper;

    @Override
    public List<Shop> findAll() {
        return shopMapper.findAllShops();
    }

    @Override
    public Shop addShop(Shop shop) {
        var id = UUID.randomUUID();
        shopMapper.addShop(id, shop);
        return shopMapper.findShopById(id);
    }

    @Override
    public Shop updateShop(Shop shop) {
        // TODO check if not exists
        shopMapper.updateShop(shop);
        return shopMapper.findShopById(shop.getId());
    }

    public void updateShopMiddleRate(UUID shopId, List<Long> rates) {
        OptionalDouble rate = rates.stream().mapToLong(i -> i).average();
        if (rate.isPresent())
            shopMapper.updateShopMiddleRate(shopId, rate.getAsDouble());
    }

    @Override
    public void deleteById(UUID coffeeShopId) {
        shopMapper.deleteShopById(coffeeShopId);
    }

    @Override
    public Address getAddress(UUID shopId) {
//        non used
        return null;
    }

    @Override
    public void addNewAddress(UUID shopId, Address address) {
        //        non used
    }

    @Override
    public Address updateAddress(Address address, UUID shopId) {
        addressMapper.updateAddress(address);
        return addressMapper.getAddressByShopId(shopId);
    }

    @Override
    public void deleteAddress(UUID shopId) {
//        non used
    }
}
