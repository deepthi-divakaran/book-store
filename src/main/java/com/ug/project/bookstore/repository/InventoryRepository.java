package com.ug.project.bookstore.repository;

import com.ug.project.bookstore.entity.inventory.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    Inventory findByBookIsbn(String isbn);

}
