<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 30px;
            background-color: #f0f0f0;
        }

        h3 {
            color: #444;
        }

        form {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            max-width: 400px;
            box-shadow: 0 2px 6px rgba(0,0,0,0.1);
        }

        label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
        }

        input[type="text"] {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<h3>Create new Movie</h3>
<form action="<%=request.getContextPath()%>/MovieServlet?action=Create" method="post">
    <label for="title">Title</label>
    <input type="text" id="title" name="title" required/><br>

    <label for="director">Director</label>
    <input type="text" id="director" name="director" required/><br>

    <label for="genre">Genre</label>
    <input type="text" id="genre" name="genre" required/><br>

    <label for="description">Description</label>
    <input type="text" id="description" name="description" required/><br>

    <label for="duration">Duration</label>
    <input type="text" id="description" name="description" required/><br>

    <label for="language">Language</label>
    <input type="text" id="language" name="language" required/><br>

    <input type="submit" value="Create"/>
</form>
</body>
</html>
