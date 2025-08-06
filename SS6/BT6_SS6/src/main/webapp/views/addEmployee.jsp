<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Thêm nhân viên</title></head>
<body>
<h2>Thêm nhân viên mới</h2>
<form action="/employees" method="post">
  Họ tên: <input type="text" name="name"><br><br>
  Email: <input type="email" name="email"><br><br>
  Vị trí: <input type="text" name="position"><br><br>
  <button type="submit">Thêm mới</button>
</form>
</body>
</html>