package ru.coffee.nostresso.service.review;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.coffee.nostresso.model.entity.Review;
import ru.coffee.nostresso.model.mapper.ReviewMapper;

import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class ReviewServiceImpl implements IReviewService {

    private ReviewMapper reviewMapper;

    @Override
    public Iterable<Review> findAll() {
        return reviewMapper.findAll();
    }

    @Override
    public Iterable<Review> findByShop(UUID shopId) {
        return reviewMapper.findByShop(shopId);
    }

    @Override
    public Iterable<Review> findByUser(UUID userId) {
        return reviewMapper.findByUser(userId);
    }

    @Override
    public UUID addReview(Review item) {
        var id = UUID.randomUUID();
        reviewMapper.addReview(id, item);
        return id;
    }

    @Override
    public void updateReview(Review item) {
        reviewMapper.updateReview(item);
    }

    @Override
    public void deleteById(UUID id) {
        reviewMapper.deleteById(id);
    }
}
