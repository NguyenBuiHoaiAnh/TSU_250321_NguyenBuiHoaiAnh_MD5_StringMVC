<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Kiểm tra đăng nhập</title>
</head>
<body>
<form action="hello-servlet" method="post">
    <label>Username</label><br>
    <input name="username" type="text"><br>

    <label>Password</label><br>
    <input name="password" type="text"><br>

    <button type="submit">Đăng nhập</button>

    <c:if test="${isValid}">
        <h2>Đăng nhập thành công!</h2>
        <p>Chào mừng <strong>${username}</strong>!</p>
    </c:if>

    <c:if test="${!isValid && isValid != null}">
        <h2>Đăng nhập thất bại!</h2>
        <p>Tên đăng nhập hoặc mật khẩu không đúng. Vui lòng thử lại.</p>
    </c:if>

    <%
        System.out.println(request.getAttribute("isValid"));
    %>

</form>
</body>
</html>
