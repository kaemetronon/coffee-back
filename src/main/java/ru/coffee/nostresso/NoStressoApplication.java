package ru.coffee.nostresso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.coffee.nostresso.model.mapper.ReviewMapper;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.UUID;

@SpringBootApplication
@EnableSwagger2
public class NoStressoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(NoStressoApplication.class, args);
    }

//    @Autowired
//    private ReviewMapper reviewMapper;

    @Override
    public void run(String... args) {
//        var x = reviewMapper
//                .getRatesByShop(UUID.fromString("91a40717-c635-4af2-8ea9-787836af3a08"));
//        var ratesByShop = reviewMapper
//                .getRatesByShop(UUID.fromString("136eb47c-2ae3-4622-9e08-604b0b331191"));
//        var ratesByShop1 = reviewMapper
//                .getRatesByShop(UUID.fromString("aff5e52b-a1b8-4a4e-9e95-bfed96c27e87"));
    }
}
