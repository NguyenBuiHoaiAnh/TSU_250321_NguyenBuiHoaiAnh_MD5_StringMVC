<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Thêm sản phẩm</h1>
<form:form action="/product" method="post" modelAttribute="p">

    <form:label path="name">Product Name</form:label><br>
    <form:input path="name"/><br>

    <form:label path="price">Price</form:label><br>
    <form:input path="price"/><br>

    <form:label path="description">Description</form:label><br>
    <form:input path="description"/><br>

    <form:button>Thêm sản phẩm</form:button>

</form:form>
</body>
</html>
