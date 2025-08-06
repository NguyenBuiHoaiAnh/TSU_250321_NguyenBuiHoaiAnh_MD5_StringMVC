<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Seed Shop</h2>
<c:forEach var="seed" items="${seeds}">
    <div>
        <img src="${seed.imageUrl}" width="100" /><br/>
            ${seed.seedsName} - ${seed.price} VND
    </div>
</c:forEach>
</body>
</html>
