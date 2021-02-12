package ru.coffee.nostresso.repo;

import org.springframework.data.repository.CrudRepository;
import ru.coffee.nostresso.model.History;

import java.util.Optional;
import java.util.UUID;

public interface HistoryRepo extends CrudRepository<History, UUID> {
    Optional<History> findByUserId(UUID userId);
}
