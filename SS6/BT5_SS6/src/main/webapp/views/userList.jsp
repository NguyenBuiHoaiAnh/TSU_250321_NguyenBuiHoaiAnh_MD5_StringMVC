<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Danh sách người dùng</title>
  <style>
    table {
      border-collapse: collapse;
      width: 90%;
      margin: 20px auto;
    }
    th, td {
      border: 1px solid #aaa;
      padding: 10px;
      text-align: center;
    }
    th {
      background-color: #eee;
    }
  </style>
</head>
<body>
<h2 style="text-align:center;">Danh sách người dùng</h2>
<table>
  <thead>
  <tr>
    <th>Tên</th>
    <th>Tuổi</th>
    <th>Ngày sinh</th>
    <th>Email</th>
    <th>Điện thoại</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="user" items="${users}">
    <tr>
      <td>${user.name}</td>
      <td>${user.age}</td>
      <td>${user.birthday}</td>
      <td>${user.email}</td>
      <td>${user.phone}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
