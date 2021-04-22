package ru.coffee.nostresso.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import ru.coffee.nostresso.model.entity.Review;

import java.util.List;
import java.util.UUID;

@Repository
@Mapper
public interface ReviewMapper {

    Review findReviewById(UUID reviewId);

    List<Review> findAllReviews();

    List<Review> findReviewByShop(UUID shopId);

    List<Review> findReviewByUser(UUID userId);

    List<Long> getRatesByShop(UUID shopId);

    void addReview(UUID id, Review item);

    void updateReview(Review item);

    void deleteReviewById(UUID itemId);

    Review getReviewById(UUID id);
}
