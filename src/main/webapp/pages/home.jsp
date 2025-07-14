<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Mall Billing System</title>
    <link rel="stylesheet" href="../css/home.css" />
    <link rel="stylesheet" href="../css/sidebar.css" />
    <link rel="stylesheet" href="../css/theme.css">
    <script>
        function toggleMenu() {
            document.getElementById("sidebar").classList.toggle("open");
        }
    </script>
    <script>
    const toggle = document.getElementById('themeToggle');
    toggle.addEventListener('change', () => {
        document.body.classList.toggle('dark-mode');
    });
</script>
</head>
<body>
    <!-- Hamburger Icon -->
    <div class="hamburger" onclick="toggleMenu()">☰</div>
    <div class="toggle-container">
  <label class="switch">
    <input type="checkbox" id="themeToggle">
    <span class="slider round"></span>
  </label>
</div>
    <!-- Sidebar -->
    <div id="sidebar" class="sidebar">
        <a href="/groceries/history">📦 Grocery Bill History</a>
        <a href="/movies/history">🎬 Movie Bill History</a>
        <a href="/food/history">🍔 Food Bill History</a>
    </div>

    <h1>🏢 Welcome to Mall Billing System</h1>

    <div class="card-container">
        <div class="card" onclick="location.href='/groceries'">
            <img src="../images/grocery.jpg" alt="Groceries" />
            <label>Grocery Billing</label>
        </div>

        <div class="card" onclick="location.href='/movies'">
            <img src="../images/movie.jpg" alt="Movies" />
            <label>Movie Booking</label>
        </div>

        <div class="card" onclick="location.href='/food'">
            <img src="../images/food.jpg" alt="Food" />
            <label>Food Ordering</label>
        </div>
    </div>
    
    
</body>
</html>
