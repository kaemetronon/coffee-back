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

    }
}
