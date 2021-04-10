package ru.coffee.nostresso.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import ru.coffee.nostresso.model.entity.OrderHistory;

import java.util.Optional;
import java.util.UUID;

@Repository
@Mapper
public interface OrderHistoryMapper {
    OrderHistory findHistoriesByUserId(UUID userId);
}
