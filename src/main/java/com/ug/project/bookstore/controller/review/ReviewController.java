package com.ug.project.bookstore.controller.review;

import com.ug.project.bookstore.common.rest.RequestPath;
import com.ug.project.bookstore.dto.review.ReviewDTO;
import com.ug.project.bookstore.service.review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RequestPath.REVIEW)
public class ReviewController {


    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<ReviewDTO> submitReview(@RequestBody ReviewDTO reviewDTO) {
        return ResponseEntity.ok(reviewService.submitReview(reviewDTO));
    }
}
