package ru.coffee.nostresso.controller.common;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.coffee.nostresso.model.entity.Review;
import ru.coffee.nostresso.service.review.IReviewService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {

    private final IReviewService reviewService;

    @GetMapping("/byShop")
    public List<Review> getReviewsByShop(@RequestParam UUID shopId) {
        return reviewService.findByShop(shopId);
    }

    @GetMapping("/byUser")
    public List<Review> getReviewsByUser(@RequestParam UUID userId) {
        return reviewService.findByUser(userId);
    }

    @PostMapping
    public UUID addReview(@RequestParam UUID shopId, @RequestBody Review review) {
        return reviewService.addReview(shopId, review);
    }

    @PutMapping
    public String updateReivew(@RequestParam UUID shopId, @RequestBody Review review) {
        reviewService.updateReview(shopId, review);
        return "review updated";
    }

    @DeleteMapping
    public String deleteReview(@RequestParam UUID reviewId) {
        reviewService.deleteById(reviewId);
        return "review  " + reviewId + " deleted";
    }
}
