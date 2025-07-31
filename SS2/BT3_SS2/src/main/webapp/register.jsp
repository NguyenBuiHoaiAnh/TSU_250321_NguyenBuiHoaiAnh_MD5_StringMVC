<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Form Đăng ký</title>
</head>
<body>
<h2>Đăng ký người dùng</h2>
<form action="result.jsp" method="post">
  <label>Họ tên:</label><br>
  <input type="text" name="name" required><br>

  <label>Email:</label><br>
  <input type="email" name="email" required><br>

  <label>Mật khẩu:</label><br>
  <input type="password" name="password" required><br>

  <button type="submit">Đăng ký</button>
</form>
</body>
</html>