<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Note App</title>
</head>
<body>
<h2>Note Application</h2>

<form action="NoteServlet" method="post">
    <input type="text" name="note" placeholder="Enter your note here" required>
    <button type="submit">Note</button>
    <ul>
        <%
            List<String> todoList = (List<String>) request.getAttribute("todo");
            if (todoList != null) {
                for (String task : todoList) {
        %>
        <li><%=task%></li>
        <%
                }
            }
        %>

    </ul>
</form>

</body>
</html>