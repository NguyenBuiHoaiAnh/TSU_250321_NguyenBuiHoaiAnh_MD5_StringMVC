<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
  <title>Kết quả đăng ký</title>
</head>
<body>
<h2>Đăng ký thành công!</h2>
<p><strong>Tên:</strong> ${user.username}</p>
<p><strong>Email:</strong> ${user.email}</p>
<p><strong>Số điện thoại:</strong> ${user.phoneNumber}</p>
</body>
</html>