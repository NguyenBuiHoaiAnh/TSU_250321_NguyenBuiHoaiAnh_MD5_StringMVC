<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sách sản phẩm</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Tên sản phẩm</th>
        <th>Giá</th>
        <th>Mô tả</th>
        <th>Hình ảnh</th>
    </tr>
    <c:forEach var="product" items="${productsList}">
        <tr>
            <td>${product.id}</td>
            <td>${product.productName}</td>
            <td>${product.price} VND</td>
            <td>${product.description}</td>
            <td><img src="${pageContext.request.contextPath}/${product.image}" alt="${product.productName}"></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
