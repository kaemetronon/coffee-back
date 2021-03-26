//package ru.coffee.nostresso;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//import ru.coffee.nostresso.model.entity.Review;
//import ru.coffee.nostresso.service.review.IReviewService;
//
//import static org.junit.Assert.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ReviewServiceTest {
//    @Autowired
//    private IReviewService reviewService;
//
//    private Long reviewId = 1L;
//    private Long shopId = 2L;
//    private Long userid = 3L;
//
//    @Test
//    public void getAllReviews() {
//        assertNotNull(reviewService.findAll());
//    }
//
//    @Test
//    public void getReviewsByShop() {
//        assertNotNull(reviewService.findByShop(shopId));
//    }
//
//    @Test
//    public void getReviewsByUser() {
//        assertNotNull(reviewService.findByUser(userid));
//    }
//
//    @Test
//    @Transactional(timeout = 7200)
//    public void addReveiw() {
//        var i = createReview();
//        var id = reviewService.addReview(shopId, i);
//        assertEquals(1, reviewService.findAll().stream()
//                .filter(o -> o.getId().equals(id)).count());
//    }
//
//
//    @Test
//    @Transactional(timeout = 7200)
//    public void updateItem() {
//        var i = createReview();
//        i.setId(reviewId);
//        reviewService.updateReview(shopId, i);
//        assertEquals(1, reviewService.findAll().stream()
//                .filter(o -> o.getId().equals(i.getId()) && o.getRate().equals(i.getRate())).count());
//    }
//
//    @Test
//    @Transactional(timeout = 7200)
//    public void deleteItem() {
//        var was = reviewService.findAll().size();
//        reviewService.deleteById(shopId, reviewId);
//        var became = reviewService.findAll().size();
//        assertEquals(1, was - became);
//    }
//
//    private Review createReview() {
//        var i = new Review();
//        i.setId(2L);
//        i.setDescription("desccc");
//        i.setRate(55L);
//        i.setShopId(shopId);
//        i.setUserId(userid);
//        return i;
//    }
//}
