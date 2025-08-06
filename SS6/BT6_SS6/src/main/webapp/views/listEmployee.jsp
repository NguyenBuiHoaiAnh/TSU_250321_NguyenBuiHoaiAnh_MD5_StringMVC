<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Danh sách nhân viên</title></head>
<body>
<h2>Danh sách nhân viên</h2>
<table border="1" cellpadding="10">
  <tr>
    <th>Họ tên</th>
    <th>Email</th>
    <th>Vị trí</th>
  </tr>
  <c:forEach items="${employees}" var="emp">
    <tr>
      <td>${emp.name}</td>
      <td>${emp.email}</td>
      <td>${emp.position}</td>
    </tr>
  </c:forEach>
</table>
<br>
<a href="/employees/add">Thêm nhân viên mới</a>
</body>
</html>