package com.ug.project.bookstore.dto.book;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BookDTO {
    private Long id;

    private String title;

    private String author;

    private String isbn;

    private BigDecimal price;

    private String availabilityStatus;
}
