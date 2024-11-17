package com.ug.project.bookstore.entity.review;

import com.ug.project.bookstore.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "review")
@Getter
@Setter
public class Review extends BaseEntity {

    private String bookIsbn;

    private String reviewerName;

    private String reviewText;

}
