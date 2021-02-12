package ru.coffee.nostresso.repo;

import org.springframework.data.repository.CrudRepository;
import ru.coffee.nostresso.model.CoffeeShop;

import java.util.Optional;
import java.util.UUID;

public interface CoffeeShopRepo extends CrudRepository<CoffeeShop, UUID> {
    Optional<CoffeeShop> findById(UUID id);
}
