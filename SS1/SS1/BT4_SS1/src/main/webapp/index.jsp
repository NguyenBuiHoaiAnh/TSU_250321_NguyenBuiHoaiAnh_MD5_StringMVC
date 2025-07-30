<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Thực hiện chức năng đăng nhập</title>
    <style>
        .card {
            background-color: gray;
            width: 450px;
            padding: 10px;
        }
        form {
            width: auto;
            height: auto;
            background-color: white;
            border-radius: 5px;
            margin: 10px;
            text-align: center;
        }
        h2 {
            text-align: center;
            padding: 20px;
        }
        input {
            width: 250px;
            border: 2px solid gray;
            border-radius: 2px;
            margin: 10px;
            padding: 10px;
        }
        button {
            border: white;
            border-radius: 2px;
            width: 280px;
            margin: 20px;
            background-color: forestgreen;
            color: white;
            text-align: center;
            padding: 10px;
        }
        .error {
            color: red;
        }

    </style>
</head>
<body>
<div class="card">
    <form action="login" method="post">
        <h2>Đăng nhập</h2>
        <p class="error">${error != null ? error : ""}</p>
        <input type="text" name="username" placeholder="Tên đăng nhập">
        <br>
        <input type="password" name="password" placeholder="Mật khẩu">
        <br>
        <button type="submit">Đăng nhập</button>
    </form>
</div>
</body>
</html>