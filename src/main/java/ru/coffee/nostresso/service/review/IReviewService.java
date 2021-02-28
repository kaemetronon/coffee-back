package ru.coffee.nostresso.service.review;

import ru.coffee.nostresso.model.entity.Review;

import java.util.UUID;

public interface IReviewService {

    Iterable<Review> findAll();

    Iterable<Review> findByShop(UUID userId);

    Iterable<Review> findByUser(UUID userId);

    UUID addReview(Review item);

    void updateReview(Review item);

    void deleteById(UUID itemId);
}
