package ru.coffee.nostresso.repo;

import org.springframework.data.repository.CrudRepository;
import ru.coffee.nostresso.model.Review;

import java.util.UUID;

public interface ReviewRepo extends CrudRepository<Review, UUID> {
}
