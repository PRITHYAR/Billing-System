<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Food Bill</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/food_bill.css" />
</head>
<body>
    <div class="bill-container">
        <h1>🧾 Food Bill</h1>

        <hr/>

        <table class="bill-table">
            <thead>
                <tr>
                    <th>Item</th>
                    <th>Price (₹)</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${items}">
                    <tr>
                        <td>${item.name}</td>
                        <td>${item.price}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div class="totals">
            <p><b>Subtotal:</b> ₹${subtotal}</p>
            <p><b>Tax (12%):</b> ₹${tax}</p>
            <p><strong>Total:</strong> ₹${total}</p>
        </div>

        <p class="thanks">Thank you for your order! 😊</p>

        <a href="/" class="btn-back">🔙 Back to Home</a>
    </div>
</body>
</html>
