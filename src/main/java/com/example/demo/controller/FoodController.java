package com.example.demo.controller;

import com.example.demo.model.FoodItem;
import com.example.demo.model.FoodBill;
import com.example.demo.Repository.FoodBillRepository;
import com.example.demo.service.BillingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@Controller
public class FoodController {

    @Autowired
    private FoodBillRepository foodBillRepository;

    BillingService billingService = new BillingService();

    List<FoodItem> foodList = Arrays.asList(
        new FoodItem("pizza", 120.0),
        new FoodItem("food", 80.0),
        new FoodItem("sandwich", 50.0),
        new FoodItem("pasta", 100.0),
        new FoodItem("frenchfries", 60.0),
        new FoodItem("friedrice", 90.0),
        new FoodItem("noodles", 85.0),
        new FoodItem("samosa", 20.0),
        new FoodItem("springroll", 70.0),
        new FoodItem("icecream", 50.0),
        new FoodItem("colddrink", 40.0),
        new FoodItem("panneerroll", 95.0)
    );

    @GetMapping("/food")
    public String showFood(Model model) {
        model.addAttribute("items", foodList);
        return "food";
    }

    @PostMapping("/food/bill")
    public String generateFoodBill(@RequestParam Map<String, String> params, Model model) {

        String customerName = params.get("customerName");

        List<FoodItem> orderedItems = new ArrayList<>();
        double subtotal = 0;

        for (FoodItem item : foodList) {
            String qtyStr = params.get(item.getName());
            if (qtyStr != null && !qtyStr.isEmpty()) {
                int qty = Integer.parseInt(qtyStr);
                if (qty > 0) {
                    double total = item.getPrice() * qty;
                    subtotal += total;
                    orderedItems.add(new FoodItem(item.getName() + " x" + qty, total));
                }
            }
        }

        double tax = billingService.calculateTax(subtotal, 0.12); // 12% tax
        double grandTotal = subtotal + tax;

        // Save to DB
        FoodBill bill = new FoodBill(customerName, grandTotal, LocalDate.now());
        foodBillRepository.save(bill);

        model.addAttribute("items", orderedItems);
        model.addAttribute("subtotal", subtotal);
        model.addAttribute("tax", tax);
        model.addAttribute("total", grandTotal);

        return "food_bill";
    }

    @GetMapping("/food/history")
    public String foodHistory(Model model, @RequestParam(required = false) String date) {
        List<FoodBill> bills;
        if (date != null && !date.isEmpty()) {
            LocalDate filterDate = LocalDate.parse(date);
            bills = foodBillRepository.findByPurchaseDate(filterDate);
        } else {
            bills = foodBillRepository.findAll();
        }
        model.addAttribute("bills", bills);
        return "food_history"; // JSP file name
    }
}
