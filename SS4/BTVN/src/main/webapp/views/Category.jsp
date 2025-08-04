<%@ page import="com.example.btvn.model.Category" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách danh mục sản phẩm</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 20px;
            background-color: #f2f2f2;
        }

        h1 {
            color: #333;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            background-color: white;
        }

        th, td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        a {
            margin-right: 10px;
            color: #0066cc;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }

        a.button-link {
            display: inline-block;
            padding: 10px 18px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 6px;
            font-size: 14px;
            transition: background-color 0.3s ease;
            margin-bottom: 20px;
        }

        a.button-link:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>CateName</th>
        <th>Description</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
    <c:if test="${not empty categoriesList}">
        <c:forEach items="${categoriesList}" var="category">
            <tr>
                <td>${category.id}</td>
                <td>${category.cateName}</td>
                <td>${category.description}</td>
                <td>${category.status?"Active":"Deactive"}</td>
                <td>
                    <a href="<%=request.getContextPath()%>/CategoryController?action=initUpdate&id=${category.id}">Update</a>
                    <a href="<%=request.getContextPath()%>/CategoryController?action=Delete&id=${category.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
</table>

<a href="<%=request.getContextPath()%>/views/AddCategory.jsp" class="button-link">Create new category</a>

</body>
</html>
