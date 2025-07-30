<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hiển thị dữ liệu từ Servlet sang JSP</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .card {
            width: 250px;
            padding-left: 20px;
            border: 2px solid black;
            text-align: left;
        }
        .card h1 {
            text-align: center;
        }

    </style>
</head>
<body>
<div class="card">
    <h1>User Data</h1>
    <h3>ID: ${id}</h3>
    <h3>Name: ${name}</h3>
    <h3>Email: ${email}</h3>
    <h3>Age: ${age}</h3>
</div>

</body>
</html>