package com.product.review.dto;

import com.product.review.domain.Review;

import java.math.BigDecimal;

public class ReviewResponse {
    private Long id;
    private String content;
    private BigDecimal star;

    private ReviewResponse() {}

    public ReviewResponse(Review review) {
        this.id = review.getId();
        this.content = review.getContent();
        this.star = review.getStar();
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public BigDecimal getStar() {
        return star;
    }
}

