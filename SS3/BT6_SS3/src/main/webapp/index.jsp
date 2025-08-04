<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f2f5;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        form {
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15);
            width: 300px;
        }

        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
            color: #555;
        }

        input {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 14px;
        }

        button {
            width: 100%;
            padding: 10px;
            background-color: #1877f2;
            color: white;
            border: none;
            border-radius: 6px;
            font-size: 16px;
            cursor: pointer;
        }

        button:hover {
            background-color: #166fe5;
        }

        p {
            text-align: center;
            margin-top: 15px;
        }
    </style>
</head>
<body>
<form action="LoginController" method="post">
    <label for="name">User Name</label>
    <input type="text" id="name" name="name" required><br>
    <label for="password">Password</label>
    <input type="text" id="password" name="password" required><br>
    <button type="submit">Send</button>
</form>
<p style="color:red">
    <%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %>
</p>
</body>
</html>