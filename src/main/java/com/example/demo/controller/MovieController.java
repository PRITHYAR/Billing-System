package com.example.demo.controller;

import com.example.demo.model.Movie;
import com.example.demo.model.MovieBill;
import com.example.demo.Repository.MovieBillRepository;
import com.example.demo.service.BillingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class MovieController {

    @Autowired
    private MovieBillRepository movieBillRepository;

    BillingService billingService = new BillingService();

    List<Movie> movieList = Arrays.asList(
        new Movie("inception", 150.0),
        new Movie("interstellar", 180.0),
        new Movie("avengers", 200.0)
    );

    @GetMapping("/movies")
    public String showMovies(Model model) {
        model.addAttribute("movies", movieList);
        return "movies";
    }

    @PostMapping("/movies/bill")
    public String generateMovieBill(@RequestParam Map<String, String> params, Model model) {

        String customerName = params.get("customerName");

        Movie selectedMovie = null;
        int seats = 0;

        for (Movie movie : movieList) {
            String qtyStr = params.get(movie.getName());
            if (qtyStr != null && !qtyStr.isEmpty()) {
                int qty = Integer.parseInt(qtyStr);
                if (qty > 0) {
                    selectedMovie = movie;
                    seats = qty;
                    break; // Only one movie should be selected
                }
            }
        }

        if (selectedMovie == null || seats <= 0) {
            model.addAttribute("error", "No movie selected or invalid seat count.");
            return "error";
        }

        double baseAmount = selectedMovie.getPrice() * seats;
        double tax = billingService.calculateTax(baseAmount, 0.18); // 18% GST
        double total = baseAmount + tax;

        // Save to DB
        MovieBill bill = new MovieBill(customerName, selectedMovie.getName(), seats, total, LocalDate.now());
        movieBillRepository.save(bill);

        model.addAttribute("movieName", selectedMovie.getName());
        model.addAttribute("seats", seats);
        model.addAttribute("amount", baseAmount);
        model.addAttribute("tax", tax);
        model.addAttribute("total", total);

        return "movies_bill";
    }
    
    @GetMapping("/movies/history")
    public String movieHistory(Model model, @RequestParam(required = false) String date) {
        List<MovieBill> bills;
        if (date != null && !date.isEmpty()) {
            LocalDate filterDate = LocalDate.parse(date);
            bills = movieBillRepository.findByPurchaseDate(filterDate);
        } else {
            bills = movieBillRepository.findAll();
        }
        model.addAttribute("bills", bills);
        return "movie_history"; // JSP file
    }
}