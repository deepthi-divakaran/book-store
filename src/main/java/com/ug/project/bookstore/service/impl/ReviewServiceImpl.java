package com.ug.project.bookstore.service.impl;

import com.ug.project.bookstore.dto.review.ReviewDTO;
import com.ug.project.bookstore.entity.review.Review;
import com.ug.project.bookstore.repository.ReviewRepository;
import com.ug.project.bookstore.service.review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public ReviewDTO submitReview(ReviewDTO reviewDTO) {
        Review review = new Review();
        review.setBookIsbn(reviewDTO.getBookIsbn());
        review.setReviewerName(reviewDTO.getReviewerName());
        review.setReviewText(reviewDTO.getReviewText());
        reviewRepository.save(review);
        return reviewDTO;
    }

    // Methods to get reviews and ratings by book ISBN (not shown for brevity)
}
