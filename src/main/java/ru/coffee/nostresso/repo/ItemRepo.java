package ru.coffee.nostresso.repo;

import org.springframework.data.repository.CrudRepository;
import ru.coffee.nostresso.model.Item;

import java.util.UUID;

public interface ItemRepo extends CrudRepository<Item, UUID> {
}
