package ru.coffee.nostresso.repo;

import org.springframework.data.repository.CrudRepository;
import ru.coffee.nostresso.model.CoffeeShop;

import java.util.Optional;

public interface CoffeeShopRepo extends CrudRepository<CoffeeShop, Integer> {
    Optional<CoffeeShop> findById(Integer id);
}
