package com.product.review;

import com.product.common.ResponseMessage;
import com.product.review.dto.ReviewRequest;
import com.product.review.dto.ReviewResponse;
import com.product.review.dto.ReviewUpdateRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping()
    public ResponseMessage<List<ReviewResponse>> getAllReview(@RequestParam Long productId) {
        List<ReviewResponse> responses = this.reviewService.findAllByProductId(productId);
        return new ResponseMessage<>(responses);
    }

    @PostMapping()
    public ResponseMessage<String> insertReview(@RequestBody @Valid ReviewRequest request) {
        this.reviewService.insertReview(request);
        return ResponseMessage.ok();
    }

    @PatchMapping("/{id}")
    public ResponseMessage<String> updateReview(
            @PathVariable Long id,
            @RequestBody ReviewUpdateRequest request
    ) {
        this.reviewService.updateReview(id, request);
        return ResponseMessage.ok();
    }

    @DeleteMapping("/{id}")
    public ResponseMessage<String> deleteReview(@PathVariable Long id) {
        this.reviewService.deleteReview(id);
        return ResponseMessage.ok();
    }
}
