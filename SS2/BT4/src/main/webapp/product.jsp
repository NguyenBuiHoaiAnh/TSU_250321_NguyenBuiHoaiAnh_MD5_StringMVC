<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <title>Title</title>
    <link rel="stylesheet" href="./product.css">
<%--    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"--%>
<%--          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">--%>
</head>
<body>
<h1>Quản lí sản phẩm</h1>
<h2>Thêm sản phẩm</h2>
<form action="ProductServlet" method="post" class="form-group">
    <label>ID</label><br>
    <input name="id" type="number"><br>

    <label>Tên sản phẩm</label><br>
    <input name="name" type="text"><br>

    <label>Giá</label><br>
    <input name="price" type="number"><br>

    <label>Mô tả</label><br>
    <input name="description" type="text"><br>

    <label>Số lượng</label><br>
    <input name="quantity" type="number"><br>

    <button type="submit" class="btn btn-primary">Thêm sản phẩm</button>
</form>

<h2>Danh sách sản phẩm đã thêm</h2>

<table class="table">

    <tr>
        <th>ID</th>
        <th>Tên sản phẩm</th>
        <th>Giá</th>
        <th>Mô tả</th>
        <th>Số lượng</th>
        <th>Trạng thái</th>
    </tr>

    <c:forEach var="product" items="${productList}">
        <tr>
            <td>${product.id}</td>
            <td>${product.productName}</td>
            <td>${product.price}</td>
            <td>${product.description}</td>
            <td>${product.quantity}</td>
            <td>${product.status ? "Còn hàng" : "Hết hàng"}</td>
        </tr>
    </c:forEach>
</table>

</body>

<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"--%>
<%--        integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"--%>
<%--        crossorigin="anonymous"></script>--%>
</html>
