package ru.coffee.nostresso.service.review;

import ru.coffee.nostresso.model.entity.Review;

import java.util.List;

public interface IReviewService {

    List<Review> findAll();

    List<Review> findByShop(Long userId);

    List<Review> findByUser(Long userId);

    Long addReview(Long shopId, Review item);

    void updateReview(Long shopId, Review item);

    void deleteById(Long shopId, Long itemId);
}
