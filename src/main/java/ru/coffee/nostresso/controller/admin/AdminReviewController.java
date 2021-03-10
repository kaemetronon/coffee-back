package ru.coffee.nostresso.controller.admin;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.coffee.nostresso.model.entity.Review;
import ru.coffee.nostresso.service.review.IReviewService;

import java.util.List;

@RestController
@RequestMapping("/admin/review")
@AllArgsConstructor
public class AdminReviewController {

    private final IReviewService reviewService;

    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.findAll();
    }

    @GetMapping("/byShop")
    public List<Review> getReviewsByShop(@RequestParam Long shopId) {
        return reviewService.findByShop(shopId);
    }

    @GetMapping("/byUser")
    public List<Review> getReviewsByUser(@RequestParam Long userId) {
        return reviewService.findByUser(userId);
    }

    @PostMapping
    public Long addReview(@RequestParam Long shopId, @RequestBody Review review) {
        return reviewService.addReview(shopId, review);
    }

    @PutMapping
    public String updateReivew(@RequestParam Long shopId, @RequestBody Review review) {
        reviewService.updateReview(shopId, review);
        return "review updated";
    }

    @DeleteMapping
    public String deleteReview(@RequestParam Long shopId, @RequestParam Long reviewId) {
        reviewService.deleteById(shopId, reviewId);
        return "review  " + reviewId + " deleted";
    }
}
