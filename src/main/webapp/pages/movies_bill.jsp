<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Movie Bill</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/movie_bill.css" />
</head>
<body>
    <div class="bill-container">
        <h1>🎟️ Movie Bill</h1>
        

        <hr/>

        <div class="details">
            <p><b>Movie:</b> ${movieName}</p>
            <p><b>Seats:</b> ${seats}</p>
            <p><b>Base Amount:</b> ₹${amount}</p>
            <p><b>Tax (18%):</b> ₹${tax}</p>
            <p><b>Total Amount:</b> ₹${total}</p>
        </div>

        <hr/>

        <div class="thanks">Thank you for booking with us! 🎬</div>

        <a href="/" class="btn-back">🔙 Back to Home</a>
    </div>
</body>
</html>
