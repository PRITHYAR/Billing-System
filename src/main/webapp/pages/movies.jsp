<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Movie Booking</title>
    <link rel="stylesheet" type="text/css" href="css/movie.css" />
</head>
<body>
    <div class="background"></div>
    <h2 class="heading">🎬 Movie Ticket Booking</h2>

    <form action="/movies/bill" method="post" class="movie-form">
        <div class="movie-container">
            <c:forEach var="movie" items="${movies}">
                <div class="movie-card">
                    <img src="images/${movie.name}.jpg" alt="${movie.name}" />
                    <div class="movie-title">${movie.name}</div>
                    <div class="movie-price">₹${movie.price}</div>
                    <label>Seats:</label>
                    <div class="qty-controls">
                        <button type="button" onclick="updateQty('${movie.name}', -1)">−</button>
                        <input type="number" name="${movie.name}" id="${movie.name}" value="0" min="0" readonly />
                        <button type="button" onclick="updateQty('${movie.name}', 1)">+</button>
                    </div>
                </div>
            </c:forEach>
        </div>

        <input type="text" name="customerName" placeholder="Enter your name" class="name-input" required />
        <br/>
        <button type="submit" class="submit-btn">🎟️ Generate Bill</button>
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
