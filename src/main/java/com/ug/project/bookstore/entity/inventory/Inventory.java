package com.ug.project.bookstore.entity.inventory;


import com.ug.project.bookstore.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "inventory")
@Getter
@Setter
public class Inventory extends BaseEntity {

    private String bookIsbn;

    private Integer stockQuantity;

}
