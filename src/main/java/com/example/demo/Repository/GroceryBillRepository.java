package com.example.demo.Repository;

import com.example.demo.model.GroceryBill;
import java.util.*;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GroceryBillRepository extends JpaRepository<GroceryBill, Long> {
	List<GroceryBill> findByPurchaseDate(LocalDate purchaseDate);

}
