package ru.coffee.nostresso.service.review;

import ru.coffee.nostresso.model.entity.Review;

import java.util.UUID;
import java.util.List;

public interface IReviewService {

    List<Review> findAll();

    List<Review> findByShop(UUID userId);

    List<Review> findByUser(UUID userId);

    UUID addReview(UUID shopId, Review item);

    void updateReview(UUID shopId, Review item);

    void deleteById(UUID shopId, UUID itemId);
}
