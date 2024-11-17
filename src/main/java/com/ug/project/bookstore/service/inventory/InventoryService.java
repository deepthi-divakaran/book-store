package com.ug.project.bookstore.service.inventory;

import com.ug.project.bookstore.dto.inventory.InventoryDTO;

public interface InventoryService {
    InventoryDTO addStock(InventoryDTO inventoryDTO);
    InventoryDTO updateStock(Long id, InventoryDTO inventoryDTO);
    InventoryDTO viewInventoryStatus(String bookIsbn);


}
