package com.example.demo.Repository;

import com.example.demo.model.MovieBill;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieBillRepository extends JpaRepository<MovieBill, Long> {
	  List<MovieBill> findByPurchaseDate(LocalDate purchaseDate); 
}
