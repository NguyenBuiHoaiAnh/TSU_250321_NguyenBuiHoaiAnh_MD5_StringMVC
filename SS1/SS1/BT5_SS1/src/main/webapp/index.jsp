<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Thực hiện chức năng đăng ký</title>
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
            background-color: deepskyblue;
            color: white;
            text-align: center;
            padding: 10px;
        }
        .error {
            color: red;
        }
        .success {
            color: green;
        }

    </style>
</head>
<body>
<div class="card">
    <form action="RegisterController" method="post">
        <h2>Sign up</h2>
        <p class="success">${success}</p>
        <input type="text" name="username" placeholder="Username">
        <br>
        <p class="error">${error1}</p>

        <input type="text" name="email" placeholder="Email">
        <br>
        <p class="error">${error2}</p>

        <input type="password" name="password" placeholder="Password">
        <br>
        <p class="error">${error3}</p>

        <input type="password" name="cfpassword" placeholder="Comfirm password">
        <br>
        <p class="error">${error4}</p>
        <button type="submit">Sign up</button>
    </form>
</div>
</body>
</html>