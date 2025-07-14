package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class MovieBill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private String movieName;
    private int seatsBooked;
    private double totalAmount;
    private LocalDate purchaseDate;

    public MovieBill() {}

    public MovieBill(String customerName, String movieName, int seatsBooked, double totalAmount, LocalDate purchaseDate) {
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatsBooked = seatsBooked;
        this.totalAmount = totalAmount;
        this.purchaseDate = purchaseDate;
    }

    // Getters and setters
    public Long getId() { return id; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getMovieName() { return movieName; }
    public void setMovieName(String movieName) { this.movieName = movieName; }

    public int getSeatsBooked() { return seatsBooked; }
    public void setSeatsBooked(int seatsBooked) { this.seatsBooked = seatsBooked; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public LocalDate getPurchaseDate() { return purchaseDate; }
    public void setPurchaseDate(LocalDate purchaseDate) { this.purchaseDate = purchaseDate; }
}
