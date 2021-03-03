package ru.coffee.nostresso.service.review;

import ru.coffee.nostresso.model.entity.Review;

import java.util.List;

public interface IReviewService {

    List<Review> findAll();

    List<Review> findByShop(Integer userId);

    List<Review> findByUser(Integer userId);

    Integer addReview(Integer shopId, Review item);

    void updateReview(Integer shopId, Review item);

    void deleteById(Integer shopId, Integer itemId);
}
