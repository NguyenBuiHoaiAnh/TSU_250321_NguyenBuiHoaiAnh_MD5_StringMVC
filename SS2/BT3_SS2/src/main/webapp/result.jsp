<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Kết quả đăng ký</title>
</head>
<body>
<%
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String password = request.getParameter("password");
%>

<h2>Đăng ký thành công!</h2>
<p><strong>Họ tên:</strong> <%= name %></p>
<p><strong>Email:</strong> <%= email %></p>
<p><strong>Mật khẩu:</strong> <%= password %></p> <!-- Trong thực tế KHÔNG nên hiển thị mật khẩu -->

<p style="color: green;">Cảm ơn bạn đã đăng ký!</p>
</body>
</html>