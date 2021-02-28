package ru.coffee.nostresso.controller.admin;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.coffee.nostresso.model.entity.Review;
import ru.coffee.nostresso.model.mapper.ReviewMapper;

import java.util.UUID;

@RestController
@RequestMapping("/admin/review")
@AllArgsConstructor
public class AdminReviewController {

    private final ReviewMapper reviewRepo;

    @GetMapping
    public Iterable<Review> getAllItems() {
        return reviewRepo.findAll();
    }

    @PostMapping("/")
    public Review addItem(@RequestBody Review item) {
        return reviewRepo.save(item);
    }


    @PutMapping("/")
    public Review updateItem(@RequestBody Review item) {
            return reviewRepo.save(item);
    }

    @DeleteMapping("/")
    public String deleteItem(@RequestParam UUID itemId) {
        reviewRepo.deleteById(itemId);
        return "item " + itemId + " deleted";
    }
}
