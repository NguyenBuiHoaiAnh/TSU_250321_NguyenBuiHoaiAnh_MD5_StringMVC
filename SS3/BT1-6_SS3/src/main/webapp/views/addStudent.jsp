<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Student</title>
</head>
<body>
<h3>Add Student</h3>
<form action="StudentController?action=Create" method="post">
    <label for="name">Name</label>
    <input type="text" id="name" name="name"/><br>
    <label for="age">Age</label>
    <input type="text" id="age" name="age"/><br>
    <label for="address">Address</label>
    <input type="text" id="address" name="address"/><br>
    <input type="submit" value="Create"/>
</form>
</body>
</html>
