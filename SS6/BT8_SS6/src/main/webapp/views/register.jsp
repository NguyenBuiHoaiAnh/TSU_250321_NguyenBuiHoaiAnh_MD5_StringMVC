<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="register" method="post">
    Username: <input type="text" name="username" /><br/>
    Password: <input type="password" name="password" /><br/>
    Email: <input type="email" name="email" /><br/>
    <input type="submit" value="Register" />
</form>
<p style="color:red">${error}</p>
</body>
</html>
