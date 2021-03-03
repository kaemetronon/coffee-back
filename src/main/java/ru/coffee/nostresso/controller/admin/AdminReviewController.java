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
    public List<Review> getReviewsByShop(@RequestParam Integer shopId) {
        return reviewService.findByShop(shopId);
    }

    @GetMapping("/byUser")
    public List<Review> getReviewsByUser(@RequestParam Integer userId) {
        return reviewService.findByUser(userId);
    }

    @PostMapping
    public Integer addReview(@RequestParam Integer shopId, @RequestBody Review review) {
        return reviewService.addReview(shopId, review);
    }

    @PutMapping
    public String updateReivew(@RequestParam Integer shopId, @RequestBody Review review) {
        reviewService.updateReview(shopId, review);
        return "review updated";
    }

    @DeleteMapping
    public String deleteReview(@RequestParam Integer shopId, @RequestParam Integer reviewId) {
        reviewService.deleteById(shopId, reviewId);
        return "review  " + reviewId + " deleted";
    }
}
