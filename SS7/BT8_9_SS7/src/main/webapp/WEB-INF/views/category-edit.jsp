<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Category Form</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

<div class="container">
    <h1>Edit Category</h1>

    <form:form method="post" modelAttribute="category" action="${pageContext.request.contextPath}/edit">

        <label for="id" class="label">ID</label>
        <form:input path="id" id="id" cssClass="input" readonly="true" />

        <label for="category-name" class="label">Category Name</label>
        <form:input path="categoryName" id="category-name" cssClass="input" />
        <form:errors path="categoryName" cssClass="error" />

        <label for="description" class="label">Description</label>
        <form:input path="description" id="description" cssClass="input" />
        <form:errors path="description" cssClass="error" />

        <label class="label">Status</label>
        <form:radiobutton path="status" id="status-true" value="true" />
        <label for="status-true">Active</label>

        <form:radiobutton path="status" id="status-false" value="false" />
        <label for="status-false">Inactive</label>

        <br><br>
        <input type="submit" value="Update" class="btn" />

    </form:form>
</div>

</body>
</html>
