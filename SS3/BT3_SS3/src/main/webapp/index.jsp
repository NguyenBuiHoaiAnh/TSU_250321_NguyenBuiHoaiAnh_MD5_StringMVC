<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Tạo Form Nhập Dữ Liệu Sinh Viên</h1><br/>
<form action="controller" method="post">
    <label>Name</label><br>
    <input type="text" name="name"><br>
    <label>Age</label><br>
    <input type="number" name="age" required><br>
    <label>Address</label><br>
    <input type="text" name="address"><br>
    <p name="message">${message}</p>
    <button type="submit">Send</button>
</form>

</body>
</html>