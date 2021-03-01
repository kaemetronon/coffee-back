package ru.coffee.nostresso.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import ru.coffee.nostresso.model.entity.Review;

import java.util.List;
import java.util.UUID;

@Repository
@Mapper
public interface ReviewMapper {

    List<Review> findAll();

    List<Review> findByShop(UUID shopId);

    List<Review> findByUser(UUID userId);

    List<Integer> getRatesByShop(UUID shopId);

    void addReview(UUID id, Review item);

    void updateReview(Review item);

    void deleteById(UUID itemId);
}
