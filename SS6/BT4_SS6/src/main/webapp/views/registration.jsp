<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Đăng ký</title>
</head>
<body>
<h2>Form Đăng ký</h2>
<form action="/register" method="post">
  Tên người dùng: <br>
  <input type="text" name="username" value="${username}" />
  <div style="color:red">${usernameError}</div>
  <br>

  Email: <br>
  <input type="email" name="email" value="${email}" />
  <div style="color:red">${emailError}</div>
  <br>

  Số điện thoại: <br>
  <input type="tel" name="phoneNumber" value="${phoneNumber}" />
  <div style="color:red">${phoneError}</div>
  <br>

  <input type="submit" value="Đăng ký" />
</form>
</body>
</html>