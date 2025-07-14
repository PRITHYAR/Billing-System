
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
    <title>Grocery Bill History</title>
    <link rel="stylesheet" href="../css/history.css">
    
</head>
<body>
    <h2>📦 Grocery Bill History</h2>

    <form method="get" action="/groceries/history">
        <label for="date">Search by Date:</label>
        <input type="date" id="date" name="date" />
        <input type="submit" value="Filter" />
    </form>

    <table>
        <thead>
            <tr>
                <th>Customer Name</th>
                <th>Date</th>
                <th>Total Amount</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="bill" items="${bills}">
                <tr>
                    <td>${bill.customerName}</td>
                    <td>${bill.purchaseDate}</td>
                    <td>₹${bill.totalAmount}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    

    <a href="/" class="btn-back">🔙 Back to Home</a>
    

    
</body>
</html>
