package ru.coffee.nostresso.controller.admin;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.coffee.nostresso.model.CoffeeShop;
import ru.coffee.nostresso.repo.CoffeeShopRepo;

import java.util.UUID;

@RestController
@RequestMapping("/admin/shop")
@AllArgsConstructor
public class AdminShopController {

    private final CoffeeShopRepo coffeeShopRepo;

    @GetMapping("/")
    public Iterable<CoffeeShop> getAllCoffeeShops() {
        return coffeeShopRepo.findAll();
    }

    @PostMapping("/")
    public CoffeeShop addCoffeeShop(@RequestBody CoffeeShop coffeeShop) {
        return coffeeShopRepo.save(coffeeShop);
    }


    @PutMapping("/")
    public CoffeeShop updateCoffeeShop(@RequestBody CoffeeShop coffeeShop) {
        if (coffeeShopRepo.existsById(coffeeShop.getId()))
            return coffeeShopRepo.save(coffeeShop);
        else
            throw new RuntimeException("there is not passed id");
    }

    @DeleteMapping("/")
    public String deleteCoffeeShop(@RequestParam UUID coffeeShopId) {
        coffeeShopRepo.deleteById(coffeeShopId);
        return "CoffeeShop " + coffeeShopId + " deleted";
    }
}
