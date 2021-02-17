package ru.coffee.nostresso.controller.admin;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.coffee.nostresso.model.Review;
import ru.coffee.nostresso.repo.ReviewRepo;

import java.util.UUID;

@RestController
@RequestMapping("/admin/review")
@AllArgsConstructor
public class AdminReviewController {

    private final ReviewRepo reviewRepo;

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
        if (reviewRepo.existsById(item.getId()))
            return reviewRepo.save(item);
        else
            throw new RuntimeException("there is not passed id");
    }

    @DeleteMapping("/")
    public String deleteItem(@RequestParam UUID itemId) {
        reviewRepo.deleteById(itemId);
        return "item " + itemId + " deleted";
    }
}
