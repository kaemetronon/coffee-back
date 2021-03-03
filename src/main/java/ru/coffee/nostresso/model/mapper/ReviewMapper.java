package ru.coffee.nostresso.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import ru.coffee.nostresso.model.entity.Review;

import java.util.List;

@Repository
@Mapper
public interface ReviewMapper {

    List<Review> findAll();

    List<Review> findByShop(Integer shopId);

    List<Review> findByUser(Integer userId);

    List<Integer> getRatesByShop(Integer shopId);

    void addReview(Integer id, Review item);

    void updateReview(Review item);

    void deleteById(Integer itemId);
}
