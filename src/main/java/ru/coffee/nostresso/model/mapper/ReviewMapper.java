package ru.coffee.nostresso.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import ru.coffee.nostresso.model.entity.Review;

import java.util.List;

@Repository
@Mapper
public interface ReviewMapper {

    List<Review> findAll();

    List<Review> findByShop(Long shopId);

    List<Review> findByUser(Long userId);

    List<Long> getRatesByShop(Long shopId);

    void addReview(Long id, Review item);

    void updateReview(Review item);

    void deleteById(Long itemId);
}
