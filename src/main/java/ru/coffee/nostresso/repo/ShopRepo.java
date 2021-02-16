package ru.coffee.nostresso.repo;

import org.springframework.data.repository.CrudRepository;
import ru.coffee.nostresso.model.Shop;

import java.util.Optional;
import java.util.UUID;

public interface ShopRepo extends CrudRepository<Shop, UUID> {
    Optional<Shop> findById(UUID id);
}
