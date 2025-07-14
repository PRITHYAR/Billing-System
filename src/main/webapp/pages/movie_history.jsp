
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
    <title>Movie Bill History</title>
    <link rel="stylesheet" href="../css/history.css">
</head>
<body>
    <h2>🎬 Movie Bill History</h2>

    <form method="get" action="/movies/history">
        <input type="date" name="date" />
        <button type="submit">Search</button>
    </form>

    <table>
        <thead>
            <tr>
                <th>Customer Name</th>
                <th>Movie Name</th>
                <th>Seats Booked</th>
                <th>Total Amount</th>
                <th>Purchase Date</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="bill" items="${bills}">
                <tr>
                    <td>${bill.customerName}</td>
                    <td>${bill.movieName}</td>
                    <td>${bill.seatsBooked}</td>
                    <td>₹${bill.totalAmount}</td>
                    <td>${bill.purchaseDate}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <a href="/" class="btn-back">🔙 Back to Home</a>
</body>
</html>
