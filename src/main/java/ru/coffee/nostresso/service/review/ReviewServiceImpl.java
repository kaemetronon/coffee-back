package ru.coffee.nostresso.service.review;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.coffee.nostresso.model.entity.Review;
import ru.coffee.nostresso.model.mapper.ReviewMapper;
import ru.coffee.nostresso.service.shop.ShopServiceImpl;

import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
@Slf4j
public class ReviewServiceImpl implements IReviewService {

    private ReviewMapper reviewMapper;
    private ShopServiceImpl shopService;

    @Override
    public List<Review> findAll() {
        return reviewMapper.findAll();
    }

    @Override
    public List<Review> findByShop(Long shopId) {
        return reviewMapper.findByShop(shopId);
    }

    @Override
    public List<Review> findByUser(Long userId) {
        return reviewMapper.findByUser(userId);
    }

    @Override
    public Long addReview(Long shopId, Review item) {
        var id = new Random().nextLong();
        reviewMapper.addReview(id, item);
        shopService.updateShopMiddleRate(shopId, reviewMapper.getRatesByShop(shopId));
        return id;
    }

    @Override
    public void updateReview(Long shopId, Review item) {
        reviewMapper.updateReview(item);
        shopService.updateShopMiddleRate(shopId, reviewMapper.getRatesByShop(shopId));
    }

    @Override
    public void deleteById(Long shopId, Long id) {
        reviewMapper.deleteById(id);
        shopService.updateShopMiddleRate(shopId, reviewMapper.getRatesByShop(shopId));
    }
}
