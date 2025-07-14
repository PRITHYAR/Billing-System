<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Grocery Bill</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/grocery_bill.css">
</head>
<body>
    <div class="bill-container">
        <h1>🧾 SuperMart Grocery Bill</h1>
        <p class="datetime">${now}</p>
        <hr/>

        <table class="bill-table">
            <thead>
                <tr>
                    <th>Item</th>
                    <th>Price</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${items}">
                    <tr>
                        <td>${item.name}</td>
                        <td>₹${item.price}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <hr/>
        <div class="totals">
            <p><strong>Subtotal:</strong> ₹${subtotal}</p>
            <p><strong>Tax (5%):</strong> ₹${tax}</p>
            <p><strong>Grand Total:</strong> ₹${total}</p>
        </div>

        <hr/>
        <div class="thanks">Thank you for shopping with us!</div>

        <a href="/" class="btn-back">← Back to Home</a>
    </div>
</body>
</html>
