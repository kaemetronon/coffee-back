package ru.coffee.nostresso.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.coffee.nostresso.model.CoffeeShop;
import ru.coffee.nostresso.model.History;
import ru.coffee.nostresso.model.Item;
import ru.coffee.nostresso.model.User;
import ru.coffee.nostresso.model.response.FailResponce;
import ru.coffee.nostresso.repo.CoffeeShopRepo;
import ru.coffee.nostresso.repo.HistoryRepo;
import ru.coffee.nostresso.repo.ItemRepo;
import ru.coffee.nostresso.repo.UserRepo;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class Controller {

    private final CoffeeShopRepo coffeeShopRepo;
    private final ItemRepo itemRepo;
    private final UserRepo userRepo;
    private final HistoryRepo historyRepo;

    @GetMapping("/coffees")
    public Iterable<CoffeeShop> getAllCoffeeshops() {
        return coffeeShopRepo.findAll();
    }

    @GetMapping("/items/{coffeeShopId}")
    public Optional<CoffeeShop> getItemsFromCoffeeShop(@PathVariable UUID coffeeShopId) {
        return coffeeShopRepo.findById(coffeeShopId);
    }

    @GetMapping("/history")
    public Optional<History> getHistory(@RequestParam UUID userId) {
        return historyRepo.findByUserId(userId);
    }

    @GetMapping("/")
    public String qwe() {
        var coffeeshop = new CoffeeShop(UUID.fromString("129e9654-4b71-412e-9b43-70cf3aad4786"), "descr",
                "img path", "name", "phone");
        coffeeShopRepo.save(coffeeshop);
        coffeeShopRepo.findAll();
        coffeeShopRepo.findById(UUID.fromString("129e9654-4b71-412e-9b43-70cf3aad4786"));

        var item = new Item(UUID.fromString("1125216b-71ff-4abc-a99c-7951b4ea2aef"), coffeeshop, "name",
                "value", 1488);
        itemRepo.save(item);
        itemRepo.findAll();
        itemRepo.findById(UUID.fromString("1125216b-71ff-4abc-a99c-7951b4ea2aef"));

        var user = new User(UUID.fromString("56a24763-efd7-43c8-bc65-72c3e2019146"));
        userRepo.save(user);
        userRepo.findAll();
        userRepo.findById(UUID.fromString("56a24763-efd7-43c8-bc65-72c3e2019146"));

        var history = new History(UUID.fromString("53f7dc19-4e96-4f20-9475-69e1d0fce6c2"), user);
        historyRepo.save(history);
        historyRepo.findAll();
        historyRepo.findById(UUID.fromString("53f7dc19-4e96-4f20-9475-69e1d0fce6c2"));
        return "done";
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<FailResponce> handle(Exception e) {
        return new ResponseEntity<>(new FailResponce(e.getMessage()), HttpStatus.valueOf(501));
    }
}
