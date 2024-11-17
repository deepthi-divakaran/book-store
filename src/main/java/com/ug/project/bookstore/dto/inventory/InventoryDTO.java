package com.ug.project.bookstore.dto.inventory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventoryDTO {
    private String bookIsbn;

    private Integer stockQuantity;

}