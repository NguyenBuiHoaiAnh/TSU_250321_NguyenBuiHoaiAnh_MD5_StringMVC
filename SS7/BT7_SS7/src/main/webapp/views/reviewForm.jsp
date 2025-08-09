<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Đánh Giá Sản Phẩm</title>
</head>
<body>
<h2>Form Đánh Giá Sản Phẩm</h2>
<form:form action="review" method="post" modelAttribute="review">
  <p>
    Tên: <form:input path="username"/>
    <form:errors path="username" cssStyle="color:red"/>
  </p>

  <p>
    Email: <form:input path="email"/>
    <form:errors path="email" cssStyle="color:red"/>
  </p>

  <p>
    Đánh giá (1-5 sao): <form:input path="rating" type="number" min="1" max="5"/>
    <form:errors path="rating" cssStyle="color:red"/>
  </p>

  <p>
    Bình luận: <form:textarea path="comment"/>
    <form:errors path="comment" cssStyle="color:red"/>
  </p>

  <p><input type="submit" value="Gửi đánh giá"/></p>
</form:form>
</body>
</html>