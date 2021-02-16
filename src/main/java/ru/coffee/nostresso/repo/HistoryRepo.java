package ru.coffee.nostresso.repo;

import org.springframework.data.repository.CrudRepository;
import ru.coffee.nostresso.model.OrderHistory;

import java.util.Optional;
import java.util.UUID;

public interface HistoryRepo extends CrudRepository<OrderHistory, UUID> {
    Optional<OrderHistory> findByUserId(UUID userId);
}
