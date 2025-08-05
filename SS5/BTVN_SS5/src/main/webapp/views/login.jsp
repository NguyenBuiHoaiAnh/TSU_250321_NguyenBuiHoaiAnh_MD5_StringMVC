<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="/LoginServlet" method="post">
  <label for="username">Username</label>
  <input type="text" name="username" required><br>
  <label for="password">Password</label>
  <input type="password" name="password" required><br>
  <input type="submit" value="Login">
  <p style="color:red">${error}</p>
</form>

</body>
</html>
