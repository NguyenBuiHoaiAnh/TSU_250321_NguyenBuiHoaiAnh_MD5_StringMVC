<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Chi Tiết Phim</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f2f2f2;
      text-align: center;
    }
    .container {
      background: white;
      padding: 30px;
      border-radius: 10px;
      margin: 50px auto;
      width: 500px;
      box-shadow: 0 0 10px rgba(0,0,0,0.1);
    }
    h2 {
      margin-bottom: 20px;
    }
    p {
      text-align: left;
      margin-left: 20px;
    }
    .schedule {
      margin-top: 20px;
    }
    .schedule button {
      margin: 5px;
      padding: 8px 12px;
      background-color: #007BFF;
      border: none;
      color: white;
      border-radius: 5px;
    }
    a {
      display: block;
      margin-top: 20px;
      color: blue;
    }
  </style>
</head>
<body>
<div class="container">
  <h2>Chi Tiết Phim: <c:out value="${movie.title}" /></h2>

  <p><strong>Đạo Diễn:</strong> <c:out value="${movie.director}" /></p>
  <p><strong>Thể Loại:</strong> <c:out value="${movie.genre}" /></p>
  <p><strong>Mô Tả:</strong> <c:out value="${movie.description}" /></p>
  <p><strong>Thời Gian:</strong> <c:out value="${movie.duration}" /> phút</p>
  <p><strong>Ngôn Ngữ:</strong> <c:out value="${movie.language}" /></p>

  <div class="schedule">
    <h4>Lịch Chiếu</h4>
    <c:forEach var="schedule" items="${scheduleList}">
      <button><c:out value="${schedule.showTime}" /></button>
    </c:forEach>
  </div>

  <a href="HomeServlet?action=findAll">Quay lại Danh Sách Phim</a>
</div>
</body>
</html>