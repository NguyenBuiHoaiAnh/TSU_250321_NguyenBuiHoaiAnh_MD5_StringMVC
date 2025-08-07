<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Welcome to the website</title>
</head>
<body>
<h2>Danh Sách Phim Đang Chiếu</h2>

<div class="movie-container">
    <c:forEach var="movie" items="${moviesList}">
        <div class="movie-card">
            <h3 class="movie-title">${movie.title}</h3>
            <p class="movie-info">Đạo Diễn: ${movie.director}</p>
            <p class="movie-info">Thể Loại: ${movie.genre}</p>
            <a class="movie-link" href="HomeServlet?action=detail&id=${movie.id}">Xem Chi Tiết</a>
        </div>
    </c:forEach>
</div>
</body>
</html>
