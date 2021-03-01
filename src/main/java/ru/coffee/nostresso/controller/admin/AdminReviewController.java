package ru.coffee.nostresso.controller.admin;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.coffee.nostresso.model.entity.Review;
import ru.coffee.nostresso.service.review.IReviewService;

import java.util.UUID;

@RestController
@RequestMapping("/admin/review")
@AllArgsConstructor
public class AdminReviewController {

    private final IReviewService reviewService;

    @GetMapping
    public Iterable<Review> getAllReviews() {
        return reviewService.findAll();
    }

    @GetMapping("/byShop")
    public Iterable<Review> getReviewsByShop(@RequestParam UUID shopId) {
        return reviewService.findByShop(shopId);
    }

    @GetMapping("/byUser")
    public Iterable<Review> getReviewsByUser(@RequestParam UUID userId) {
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
    public String deleteReview(@RequestParam UUID shopId, @RequestParam UUID reviewId) {
        reviewService.deleteById(shopId, reviewId);
        return "review  " + reviewId + " deleted";
    }
}
