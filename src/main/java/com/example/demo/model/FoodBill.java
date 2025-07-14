package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class FoodBill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private double totalAmount;
    private LocalDate purchaseDate;

    public FoodBill() {}

    public FoodBill(String customerName, double totalAmount, LocalDate purchaseDate) {
        this.customerName = customerName;
        this.totalAmount = totalAmount;
        this.purchaseDate = purchaseDate;
    }

    // Getters and setters
    public Long getId() { return id; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public LocalDate getPurchaseDate() { return purchaseDate; }
    public void setPurchaseDate(LocalDate purchaseDate) { this.purchaseDate = purchaseDate; }
}

