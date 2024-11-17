package com.ug.project.bookstore.controller.inventory;

import com.ug.project.bookstore.common.rest.RequestPath;
import com.ug.project.bookstore.dto.inventory.InventoryDTO;
import com.ug.project.bookstore.service.inventory.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(RequestPath.INVENTORY)
public class InventoryController {


    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping
    public ResponseEntity<InventoryDTO> addStock(@RequestBody InventoryDTO inventoryDTO) {
        return ResponseEntity.ok(inventoryService.addStock(inventoryDTO));
    }

    @PutMapping(RequestPath.INVENTORY_BY_ID)
    public ResponseEntity<InventoryDTO> updateStock(@PathVariable Long id, @RequestBody InventoryDTO inventoryDTO) {
        return ResponseEntity.ok(inventoryService.updateStock(id, inventoryDTO));
    }

    @GetMapping
    public ResponseEntity<InventoryDTO> viewInventoryStatus(@RequestParam String bookIsbn) {
        return ResponseEntity.ok(inventoryService.viewInventoryStatus(bookIsbn));
    }
}