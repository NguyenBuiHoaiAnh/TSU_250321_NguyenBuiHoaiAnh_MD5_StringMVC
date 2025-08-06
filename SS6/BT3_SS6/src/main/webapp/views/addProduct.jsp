<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm sản phẩm</title>
</head>
<body>
<h2>Thêm sản phẩm mới</h2>
<form method="post" action="/productPost">
    <label>Tên sản phẩm:</label><br>
    <input type="text" name="name" required/><br>

    <label>Số lượng:</label><br>
    <input type="number" name="quantity" required/><br>

    <label>Giá:</label><br>
    <input type="number" name="price" required/><br>

    <input type="submit" value="Thêm mới"/>
</form>
</body>
</html>