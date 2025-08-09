<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Cơ Chế Data Binding Trong Spring MVC</title>
</head>
<body>
<h2>Nhập thông tin User</h2>
<form:form action="/user/submit" method="post" modelAttribute="user">
    <p>Tên: <form:input path="name"/></p>
    <p>Tuổi: <form:input path="age"/></p>
    <p>Địa chỉ: <form:input path="address"/></p>
    <input type="submit" value="Gửi"/>
</form:form>
</body>
</html>
