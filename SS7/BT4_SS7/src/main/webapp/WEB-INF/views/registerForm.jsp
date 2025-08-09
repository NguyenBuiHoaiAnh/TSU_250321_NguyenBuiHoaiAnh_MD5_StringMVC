<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng ký</title>
</head>
<body>
<h2>Form Đăng Ký Người Dùng</h2>

<form:form action="register" method="post" modelAttribute="user">
    <table>
        <tr>
            <td><form:label path="username">Tên:</form:label></td>
            <td><form:input path="username" /></td>
            <td><form:errors path="username" cssClass="error" /></td>
        </tr>
        <tr>
            <td><form:label path="email">Email:</form:label></td>
            <td><form:input path="email" /></td>
            <td><form:errors path="email" cssClass="error" /></td>
        </tr>
        <tr>
            <td><form:label path="password">Mật khẩu:</form:label></td>
            <td><form:password path="password" /></td>
            <td><form:errors path="password" cssClass="error" /></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Đăng ký" /></td>
        </tr>
    </table>
</form:form>
</body>
</html>
