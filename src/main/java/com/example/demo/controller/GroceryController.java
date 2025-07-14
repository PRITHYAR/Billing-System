package com.example.demo.controller;

import com.example.demo.model.GroceryItem;
import com.example.demo.model.GroceryBill;
import com.example.demo.Repository.GroceryBillRepository;
import com.example.demo.service.BillingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class GroceryController {

    @Autowired
    private GroceryBillRepository groceryBillRepository;

    BillingService billingService = new BillingService();

    List<GroceryItem> groceryList = Arrays.asList(
    		new GroceryItem("rice", 45.0),
    	    new GroceryItem("wheat", 30.0),
    	    new GroceryItem("oil", 110.0),
    	    new GroceryItem("sugar", 40.0),
    	    new GroceryItem("salt", 15.0),
    	    new GroceryItem("milk", 25.0),
    	    new GroceryItem("egg", 70.0),
    	    new GroceryItem("bread", 30.0),
    	    new GroceryItem("butter", 60.0),
    	    new GroceryItem("tea", 150.0),
    	    new GroceryItem("coffee", 130.0),
    	    new GroceryItem("biscuits", 20.0)
    );

    @GetMapping("/groceries")
    public String showGroceries(Model model) {
        model.addAttribute("items", groceryList);
        return "groceries";
    }

    @PostMapping("/groceries/bill")
    public String generateBill(@RequestParam Map<String, String> params, Model model) {

        String customerName = params.get("customerName");

        List<GroceryItem> purchasedItems = new ArrayList<>();
        double subtotal = 0;

        for (GroceryItem item : groceryList) {
            String qtyStr = params.get(item.getName());
            if (qtyStr != null && !qtyStr.isEmpty()) {
                int qty = Integer.parseInt(qtyStr);
                if (qty > 0) {
                    double total = item.getPrice() * qty;
                    subtotal += total;
                    purchasedItems.add(new GroceryItem(item.getName() + " x" + qty, total));
                }
            }
        }

        double tax = billingService.calculateTax(subtotal, 0.05); // 5% tax
        double grandTotal = subtotal + tax;

        // 💾 Save to DB
        GroceryBill bill = new GroceryBill(customerName, grandTotal, LocalDate.now());
        groceryBillRepository.save(bill);

        model.addAttribute("items", purchasedItems);
        model.addAttribute("subtotal", subtotal);
        model.addAttribute("tax", tax);
        model.addAttribute("total", grandTotal);

        return "groceries_bill";
    }
    
    @GetMapping("/groceries/history")
    public String groceryHistory(Model model, @RequestParam(required = false) String date) {
        List<GroceryBill> bills;
        if (date != null && !date.isEmpty()) {
            LocalDate filterDate = LocalDate.parse(date);
            bills = groceryBillRepository.findByPurchaseDate(filterDate); // ✅ fixed
        } else {
            bills = groceryBillRepository.findAll();
        }
        model.addAttribute("bills", bills);
        return "grocery_history";
    }
   


}
