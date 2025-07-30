<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Chuyển đổi tiền tệ</title>
    <style>
        form {
            width: 400px;
            border: 2px solid black;
            padding: 20px;
        }

        input,button {
            margin: 5px;
            padding: 10px;
            border: 2px solid gray;
            border-radius: 5px;
        }
        label {
            margin: 5px;
            font-size: 20px;
        }
    </style>
</head>
<body>

<form action="convert" method="post">
    <h1>Chuyển đổi tiền tệ</h1>
    <label>Rate</label><br>
    <input type="text" name="rate" placeholder="Enter your rate" required><br>
    <label>USD</label><br>
    <input type="text" name="usd" placeholder="Enter your usd" required>
    <br>
    <button type="submit">Convert</button>

</form>

</body>
</html>