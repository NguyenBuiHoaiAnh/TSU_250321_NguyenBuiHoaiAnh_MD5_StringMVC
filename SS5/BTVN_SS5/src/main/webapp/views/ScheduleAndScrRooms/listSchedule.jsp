<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f9f9f9;
      padding: 20px;
    }

    .title-container {
      text-align: center;
    }

    h1 {
      text-align: center;
      font-size: 32px;
      color: #2c3e50;
      margin-bottom: 40px;
      text-transform: uppercase;
      letter-spacing: 1.5px;
      position: relative;
      display: inline-block;
    }

    h1::after {
      content: '';
      display: block;
      width: 60px;
      height: 4px;
      background-color: #4CAF50;
      margin: 8px auto 0;
      border-radius: 2px;
    }

    table {
      width: 100%;
      border-collapse: collapse;
      background-color: #fff;
      box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
    }

    th, td {
      padding: 12px 15px;
      text-align: center;
      border-bottom: 1px solid #ddd;
    }

    th {
      background-color: #4CAF50;
      color: white;
    }

    tr:hover {
      background-color: #f1f1f1;
    }

    a {
      margin: 0 5px;
      color: #007BFF;
      text-decoration: none;
    }

    a:hover {
      text-decoration: underline;
    }

    .button-link {
      display: inline-block;
      margin: 30px auto 0;
      padding: 10px 20px;
      background-color: #28a745;
      color: white;
      text-decoration: none;
      border-radius: 5px;
      text-align: center;
      font-weight: bold;
      transition: background-color 0.3s;
    }

    .button-link:hover {
      background-color: #218838;
    }

    .button-container {
      text-align: center;
    }

    .btn {
      display: inline-block;
      padding: 8px 14px;
      font-size: 14px;
      font-weight: bold;
      text-decoration: none;
      border-radius: 6px;
      transition: background-color 0.3s ease;
      margin: 2px;
      color: #fff;
      border: none;
      cursor: pointer;
    }

    .btn-update {
      background-color: #007BFF;
    }

    .btn-update:hover {
      background-color: #0069d9;
    }

    .btn-delete {
      background-color: #dc3545;
    }

    .btn-delete:hover {
      background-color: #c82333;
    }

  </style>
</head>
<body>

<div class="title-container">
  <h1>Movies Schedule</h1>
</div>

<table>
  <tr>
    <th>Title</th>
    <th>Show Time</th>
    <th>Screen Room</th>
    <th>Available Seat</th>
    <th>Format(2D,3D)</th>
    <th>Action</th>
  </tr>
  <c:if test="${not empty scheduleList}">
    <c:forEach items="${scheduleList}" var="schedule">
      <tr>
        <td>${schedule.movieTitle}</td>
        <td>${schedule.showTime}</td>
        <td>${schedule.screenRoomName}</td>
        <td>${schedule.availableSeats}</td>
        <td>${schedule.format}</td>
        <td>
          <!-- Form Update -->
          <form action="<%=request.getContextPath()%>/MovieServlet" method="get" style="display:inline;">
            <input type="hidden" name="action" value="initUpdate">
            <input type="hidden" name="id" value="${movies.id}">
            <button type="submit" class="btn btn-update">Update</button>
          </form>

          <!-- Form Delete -->
          <form action="<%=request.getContextPath()%>/MovieServlet" method="get" style="display:inline;"
                onsubmit="return confirm('Are you sure you want to delete this movie?');">
            <input type="hidden" name="action" value="Delete">
            <input type="hidden" name="id" value="${movies.id}">
            <button type="submit" class="btn btn-delete">Delete</button>
          </form>
        </td>
      </tr>
    </c:forEach>
  </c:if>
</table>

<div class="button-container">
  <a href="ScheduleServlet?action=addForm" class="button-link">
    Create new movie
  </a>
</div>

</body>
</html>