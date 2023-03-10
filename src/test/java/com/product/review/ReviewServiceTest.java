package com.product.review;

import com.product.fixture.ReviewFactory;
import com.product.fixture.UserFactory;
import com.product.review.domain.Review;
import com.product.fixture.ProductFactory;
import com.product.product.repository.ProductRepository;
import com.product.product.domain.Product;
import com.product.review.dto.ReviewRequest;
import com.product.review.dto.ReviewResponse;
import com.product.review.dto.ReviewUpdateRequest;
import com.product.user.UserRepository;
import com.product.user.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ReviewServiceTest {
    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        this.reviewRepository.deleteAll();
        this.userRepository.deleteAll();
        this.productRepository.deleteAll();
    }

    @Test
    @DisplayName("리뷰를 등록할 수 있다.")
    void insert() {
        // given
        User user = userRepository.save(UserFactory.create("서정국"));
        Product product = productRepository.save(ProductFactory.create("상품 A"));
        ReviewRequest request = ReviewFactory.createRequest("최고!!", user.getId(), product.getId());

        // when
        reviewService.insertReview(request);

        // then
        Review result = reviewRepository.findAll().get(0);
        assertThat(result.getContent()).isEqualTo(request.getContent());
    }

    @Test
    @DisplayName("상품 Id에 대한 전체 리뷰를 조회할 수 있다.")
    void findAllByProductId() {
        // given
        User user = userRepository.save(UserFactory.create("서정국"));
        Product product = productRepository.save(ProductFactory.create("상품 A"));
        Review review = reviewRepository.save(ReviewFactory.create("최고!!", user, product));

        // when
        List<ReviewResponse> responses = reviewService.findAllByProductId(product.getId());

        // then
        assertThat(responses).hasSize(1);
        assertThat(responses.get(0).getContent()).isEqualTo(review.getContent());
    }

    @Test
    @DisplayName("리뷰를 수정할 수 있다.")
    void update() {
        // given
        User user = userRepository.save(UserFactory.create("서정국"));
        Product product = productRepository.save(ProductFactory.create("상품 A"));
        Review review = reviewRepository.save(ReviewFactory.create("최고!!", user, product));
        ReviewUpdateRequest request = new ReviewUpdateRequest("아니다. 최악", BigDecimal.ZERO);

        // when
        reviewService.updateReview(review.getId(), request);

        // then
        Review updatedReview = reviewRepository.findById(review.getId()).get();
        assertThat(updatedReview.getContent()).isEqualTo(request.getContent());
    }

    @Test
    @DisplayName("리뷰를 삭제할 수 있다.")
    void delete() {
        // given
        User user = userRepository.save(UserFactory.create("서정국"));
        Product product = productRepository.save(ProductFactory.create("상품 A"));
        Review review = reviewRepository.save(ReviewFactory.create("최고!!", user, product));

        // when
        reviewService.deleteReview(review.getId());

        // then
        List<Review> reviews = reviewRepository.findAll();
        assertThat(reviews).isEmpty();
    }
}
