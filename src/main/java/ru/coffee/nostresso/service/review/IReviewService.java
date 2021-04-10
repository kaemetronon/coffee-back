package ru.coffee.nostresso.service.review;

import ru.coffee.nostresso.model.entity.Review;

import java.util.List;
import java.util.UUID;

public interface IReviewService {

    List<Review> findAll();

    List<Review> findByShop(UUID userId);

    List<Review> findByUser(UUID userId);

    UUID addReview(UUID shopId, Review item);

    void updateReview(UUID shopId, Review item);

    void deleteById(UUID itemId);
}
