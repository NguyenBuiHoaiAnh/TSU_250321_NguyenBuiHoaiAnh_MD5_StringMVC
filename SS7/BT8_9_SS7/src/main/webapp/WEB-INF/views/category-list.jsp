<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Category List</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

<h1>Category List</h1>

<a href="${pageContext.request.contextPath}/add">Thêm danh mục</a>

<table border="1" cellpadding="8" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>Category Name</th>
        <th>Description</th>
        <th>Status</th>
        <th>Action</th>
    </tr>

    <c:forEach var="category" items="${categories}">
        <tr>
            <td>${category.id}</td>
            <td>${category.categoryName}</td>
            <td>${category.description}</td>
            <td>
                <c:choose>
                    <c:when test="${category.status}">
                        Hoạt động
                    </c:when>
                    <c:otherwise>
                        Không hoạt động
                    </c:otherwise>
                </c:choose>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/edit/${category.id}">Sửa</a>
                |
                <a href="${pageContext.request.contextPath}/delete/${category.id}"
                   onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>

<c:if test="${not empty errorMsg}">
    <div class="error">
        <p>${errorMsg}</p>
    </div>
</c:if>

<c:if test="${not empty successMsg}">
    <div class="success">
        <p>${successMsg}</p>
    </div>
</c:if>

</body>
</html>
