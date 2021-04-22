package ru.coffee.nostresso.controller.common;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.coffee.nostresso.model.entity.Review;
import ru.coffee.nostresso.service.review.IReviewService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
@Api(value = "User Controller",
        description = "доступен всем, кроме мест по типу byUser" +
                ", чтобы левые люди не могли смотреть за другими левыми)")
public class ReviewController {

    private final IReviewService reviewService;

    @GetMapping("/byShop")
    @ApiOperation(value = "Получение списка отзывов по конкретному шопу", response = Iterable.class)
    public List<Review> getReviewsByShop(@RequestParam UUID shopId) {
        return reviewService.findByShop(shopId);
    }

    @GetMapping("/byUser")
    @ApiOperation(value = "Получение списка отзывов от конкретного человека", response = Iterable.class)
    public List<Review> getReviewsByUser(@RequestParam UUID userId) {
        return reviewService.findByUser(userId);
    }

    @PostMapping
    @ApiOperation(value = "Добавление отзыва", response = Iterable.class)
    public Review addReview(@RequestParam UUID shopId, @RequestBody Review review) {
        return reviewService.addReview(shopId, review);
    }

    @PutMapping
    public Review updateReivew(@RequestParam UUID shopId, @RequestBody Review review) {
        return reviewService.updateReview(shopId, review);
    }

    @DeleteMapping
    public String deleteReview(@RequestParam UUID reviewId) {
        reviewService.deleteById(reviewId);
        return "review deleted";
    }
}
