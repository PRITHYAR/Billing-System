<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Grocery Billing</title>
    <link rel="stylesheet" href="<c:url value='/css/grocery.css' />">
    <script>
        function increment(id) {
            const input = document.getElementById(id);
            input.value = parseInt(input.value) + 1;
        }

        function decrement(id) {
            const input = document.getElementById(id);
            if (parseInt(input.value) > 0) {
                input.value = parseInt(input.value) - 1;
            }
        }
    </script>
</head>
<body>
    <h2>🛒 Select Your Groceries</h2>

    <form action="/groceries/bill" method="post" class="grocery-form">
        <div class="grid">
            <c:forEach var="item" items="${items}">
                <div class="card">
                    <img src="<c:url value='/images/${item.name.toLowerCase()}.jpg' />" alt="${item.name}">
                    <div class="info">
                        <h4>${item.name}</h4>
                        <p>₹${item.price}</p>
                        <div class="quantity-controls">
                            <button type="button" onclick="decrement('${item.name}')">−</button>
                            <input type="text" name="${item.name}" id="${item.name}" value="0" readonly />
                            <button type="button" onclick="increment('${item.name}')">+</button>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <input type="text" name="customerName" placeholder="Enter your name" required class="name-field" />
        <br/>
        <input type="submit" value="🧾 Generate Bill" class="submit-btn" />
    </form>
</body>
</html>
