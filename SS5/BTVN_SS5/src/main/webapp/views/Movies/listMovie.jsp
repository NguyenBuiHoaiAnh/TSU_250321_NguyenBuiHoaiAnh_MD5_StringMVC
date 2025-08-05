<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 20px;
            background-color: #f2f2f2;
        }

        h1 {
            color: #333;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            background-color: white;
        }

        th, td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        a {
            margin-right: 10px;
            color: #0066cc;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }

        a.button-link {
            display: inline-block;
            padding: 10px 18px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 6px;
            font-size: 14px;
            transition: background-color 0.3s ease;
            margin-bottom: 20px;
        }

        a.button-link:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Director</th>
        <th>Genre</th>
        <th>Description</th>
        <th>Duration</th>
        <th>Language</th>
        <th>Action</th>
    </tr>
    <c:if test="${not empty moviesList}">
        <c:forEach items="${moviesList}" var="movies">
            <tr>
                <td>${movies.id}</td>
                <td>${movies.title}</td>
                <td>${movies.director}</td>
                <td>${movies.genre}</td>
                <td>${movies.description}</td>
                <td>${movies.duration}</td>
                <td>${movies.language}</td>
                <td>
                    <a href="<%=request.getContextPath()%>/MovieServlet?action=initUpdate&id=${movies.id}">Update</a>
                    <a href="<%=request.getContextPath()%>/MovieServlet?action=Delete&id=${movies.id}"
                       onclick="return confirm('Are you sure you want to delete this movie?');">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
</table>

<a href="<%=request.getContextPath()%>/views/Movies/formAddMovie.jsp" class="button-link">Create new movie</a>

</body>
</html>