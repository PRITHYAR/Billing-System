<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Food Ordering</title>
    <link rel="stylesheet" type="text/css" href="css/food.css" />
</head>
<body>
    <div class="background"></div>
    <h2 class="heading">🍽️ Select Your Favorite Food</h2>

    <form action="/food/bill" method="post" class="food-form">
        <div class="item-container">
            <c:forEach var="item" items="${items}">
                <div class="food-card">
                    <img src="images/${item.name}.jpg" alt="${item.name}" />
                    <div class="item-name">${item.name}</div>
                    <div class="price">₹${item.price}</div>
                    <div class="qty-controls">
                        <button type="button" onclick="updateQty('${item.name}', -1)">−</button>
                        <input type="number" name="${item.name}" id="${item.name}" value="0" min="0" readonly />
                        <button type="button" onclick="updateQty('${item.name}', 1)">+</button>
                    </div>
                </div>
            </c:forEach>
        </div>

        <input type="text" name="customerName" placeholder="Enter your name" class="name-input" required />
        <br/>
        <button type="submit" class="submit-btn">🍔 Generate Bill</button>
    </form>

    <script>
        function updateQty(id, change) {
            const input = document.getElementById(id);
            let value = parseInt(input.value || '0') + change;
            if (value >= 0) input.value = value;
        }
    </script>
</body>
</html>
