package com.ug.project.bookstore.dto.review;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewDTO {

    private String bookIsbn;

    private String reviewerName;

    private String reviewText;

}