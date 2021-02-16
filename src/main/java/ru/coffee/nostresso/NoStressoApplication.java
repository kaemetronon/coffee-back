package ru.coffee.nostresso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.coffee.nostresso.model.Address;
import ru.coffee.nostresso.model.Item;
import ru.coffee.nostresso.model.Review;
import ru.coffee.nostresso.model.Shop;
import ru.coffee.nostresso.repo.ShopRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class NoStressoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(NoStressoApplication.class, args);
    }

    @Autowired
    private ShopRepo shopRepo;

    @Override
    public void run(String... args) {
        Shop shop = new Shop();
        shop.setId(UUID.randomUUID());
        Address address = new Address();
        address.setAddressText("пушкина дом колотушкина");
        address.setX(1.4);
        address.setY(8.8);
        shop.setAddress(address);
        shop.setDescription("shop descr");
        shop.setImg("img_path");
        shop.setMiddleRate(4.2);
        shop.setName("coffee name");
        shop.setPhone("14-88 number");
        List<Item> itemList = new ArrayList<>() {{add(new Item());add(new Item());}};
        for (int i = 0; i < 2; i++) {
            var item = itemList.get(i);
            item.setId(UUID.randomUUID());
            item.setName("name" + i);
            item.setCost(5*i);
            item.setVolume("volume" + i*2);
        }
        shop.setItems(itemList);

        List<Review> reviewList = new ArrayList<>(){{add(new Review());add(new Review());}};
        for (int i = 0; i < 2; i++) {
            var item = reviewList.get(i);
            item.setDescription("descr"+i);
            item.setId(UUID.randomUUID());
            item.setRate(i+2);
        }
        shop.setReviews(reviewList);
        shopRepo.save(shop);
    }
}
