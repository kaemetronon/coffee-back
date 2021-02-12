package ru.coffee.nostresso.repo;

import org.springframework.data.repository.CrudRepository;
import ru.coffee.nostresso.model.User;

import java.util.UUID;

public interface UserRepo extends CrudRepository<User, UUID> {
}
