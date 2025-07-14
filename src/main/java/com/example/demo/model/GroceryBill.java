package com.example.demo.model;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class GroceryBill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;

    private double totalAmount;

    @Column(name = "purchase_date")
    private LocalDate purchaseDate;

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }// ✅ Required field for filtering

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

  //  public LocalDate getDate() { return date; }
  //  public void setDate(LocalDate date) { this.date = date; }

    // Constructors
    public GroceryBill() {}

    public GroceryBill(String customerName, double totalAmount, LocalDate purchaseDate) {
        this.customerName = customerName;
        this.totalAmount = totalAmount;
        this.purchaseDate = purchaseDate;
    }
}
