<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Nhập Thông Tin Người Dùng</h1><br/>

<form action="login" method="post">
    <label>Tên</label><br>
    <input name="name" type="text"><br>

    <label>Email</label><br>
    <input name="email" type="text"><br>
    <button type="submit">Gửi</button>
</form>
</body>
</html>