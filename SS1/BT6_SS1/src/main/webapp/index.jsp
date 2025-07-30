<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Note App</title>
</head>
<body>
<h2>Note Application</h2>

<form action="note" method="post">
    <input type="text" name="note" placeholder="Enter your note here" required>
    <button type="submit">Note</button>
</form>

<jsp:include page="notes.jsp" />
</body>
</html>