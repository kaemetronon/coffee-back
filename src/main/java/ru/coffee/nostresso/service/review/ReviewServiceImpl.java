package ru.coffee.nostresso.service.review;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.coffee.nostresso.model.entity.Review;
import ru.coffee.nostresso.model.mapper.ReviewMapper;
import ru.coffee.nostresso.service.shop.ShopServiceImpl;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class ReviewServiceImpl implements IReviewService {

    private ReviewMapper reviewMapper;
    private ShopServiceImpl shopService;

    @Override
    public List<Review> findAll() {
        return reviewMapper.findAllReviews();
    }

    @Override
    public List<Review> findByShop(UUID shopId) {
        return reviewMapper.findReviewByShop(shopId);
    }

    @Override
    public List<Review> findByUser(UUID userId) {
        return reviewMapper.findReviewByUser(userId);
    }

    @Override
    public Review addReview(UUID shopId, Review item) {
        var id = UUID.randomUUID();
        reviewMapper.addReview(id, item);
        shopService.updateShopMiddleRate(shopId, reviewMapper.getRatesByShop(shopId));
        return reviewMapper.getReviewById(id);
    }

    @Override
    public Review updateReview(UUID shopId, Review item) {
        reviewMapper.updateReview(item);
        shopService.updateShopMiddleRate(shopId, reviewMapper.getRatesByShop(shopId));
        return reviewMapper.getReviewById(item.getId());
    }

    @Override
    public void deleteById(UUID reviewId) {
        var shopId = reviewMapper.findReviewById(reviewId).getShopId();
        reviewMapper.deleteReviewById(reviewId);
        shopService.updateShopMiddleRate(shopId, reviewMapper.getRatesByShop(shopId));
    }
}
