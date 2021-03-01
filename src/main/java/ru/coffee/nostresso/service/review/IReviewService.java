package ru.coffee.nostresso.service.review;

import ru.coffee.nostresso.model.entity.Review;

import java.util.UUID;

public interface IReviewService {

    Iterable<Review> findAll();

    Iterable<Review> findByShop(UUID userId);

    Iterable<Review> findByUser(UUID userId);

    UUID addReview(UUID shopId, Review item);

    void updateReview(UUID shopId, Review item);

    void deleteById(UUID shopId, UUID itemId);
}
