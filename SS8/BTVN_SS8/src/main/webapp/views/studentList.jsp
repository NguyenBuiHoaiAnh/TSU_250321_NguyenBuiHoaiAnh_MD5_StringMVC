<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Danh sách sinh viên</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f9fc;
            padding: 30px;
        }

        h2 {
            margin-bottom: 20px;
            color: #333;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
            background-color: #fff;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
        }

        th, td {
            padding: 12px 15px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #007bff;
            color: white;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        .action-btn {
            padding: 6px 12px;
            border-radius: 5px;
            text-decoration: none;
            color: white;
            background-color: #28a745;
            margin: 0 5px;
            transition: background-color 0.3s ease;
        }

        .action-btn:hover {
            background-color: #218838;
        }

        .action-btn.delete {
            background-color: #dc3545;
        }

        .action-btn.delete:hover {
            background-color: #c82333;
        }

        a[href$="add"] {
            display: inline-block;
            background-color: #17a2b8;
            color: white;
            padding: 10px 16px;
            border-radius: 5px;
            text-decoration: none;
            font-weight: bold;
            transition: background-color 0.3s ease;
        }

        a[href$="add"]:hover {
            background-color: #138496;
        }
    </style>
</head>
<body>

<h2 style="text-align: center;">Danh sách sinh viên</h2>

<div style="text-align: right; margin-bottom: 10px;">
    <a href="student/add">Thêm sinh viên</a>
</div>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Họ tên</th>
        <th>Email</th>
        <th>Ngày sinh</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${studentsList}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.email}</td>
            <td>${student.dob}</td>
            <td>
                <a class="action-btn" href="student/editStudent?id=${student.id}">Sửa</a>
                <a class="action-btn delete"
                   href="student/deleteStudent?id=${student.id}"
                   onclick="return confirm('Bạn có chắc chắn muốn xóa sinh viên này không?');">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>