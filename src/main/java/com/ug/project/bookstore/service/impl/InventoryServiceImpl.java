package com.ug.project.bookstore.service.impl;

import com.ug.project.bookstore.common.enums.ApiError;
import com.ug.project.bookstore.dto.inventory.InventoryDTO;
import com.ug.project.bookstore.entity.inventory.Inventory;
import com.ug.project.bookstore.exception.ApiFailedException;
import com.ug.project.bookstore.repository.InventoryRepository;
import com.ug.project.bookstore.service.inventory.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {


    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public InventoryDTO addStock(InventoryDTO inventoryDTO) {
        Inventory inventory = inventoryRepository.findByBookIsbn(inventoryDTO.getBookIsbn());

        if (inventory == null) {
            inventory = new Inventory();
            inventory.setBookIsbn(inventoryDTO.getBookIsbn());
            inventory.setStockQuantity(0);
        }

        inventory.setStockQuantity(inventory.getStockQuantity() + inventoryDTO.getStockQuantity());
        inventoryRepository.save(inventory);
        return inventoryDTO;
    }

    @Override
    public InventoryDTO updateStock(Long id, InventoryDTO inventoryDTO) {

        Inventory inventory = inventoryRepository.findById(id)
                .orElseThrow(() -> new ApiFailedException(ApiError.ITEM_NOT_FOUND));

        inventory.setStockQuantity(inventoryDTO.getStockQuantity());
        inventoryRepository.save(inventory);
        return inventoryDTO;
    }

    @Override
    public InventoryDTO viewInventoryStatus(String bookIsbn) {
        Inventory inventory = inventoryRepository.findByBookIsbn(bookIsbn);
        if (inventory == null) {
            throw new ApiFailedException(ApiError.ITEM_NOT_FOUND);
        }

        InventoryDTO inventoryDTO = new InventoryDTO();
        inventoryDTO.setBookIsbn(inventory.getBookIsbn());
        inventoryDTO.setStockQuantity(inventory.getStockQuantity());
        return inventoryDTO;
    }
}
