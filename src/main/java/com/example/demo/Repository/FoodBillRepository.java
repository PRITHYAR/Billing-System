package com.example.demo.Repository;

import com.example.demo.model.FoodBill;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodBillRepository extends JpaRepository<FoodBill, Long> {
	 List<FoodBill> findByPurchaseDate(LocalDate purchaseDate);
}

