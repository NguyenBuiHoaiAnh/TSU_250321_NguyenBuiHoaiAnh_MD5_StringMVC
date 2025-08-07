<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        h1 {
            text-align: center;
            font-size: 26px;
            color: #2c3e50;
            margin-bottom: 25px;
            text-transform: uppercase;
            letter-spacing: 1px;
            position: relative;
        }

        h1::after {
            content: '';
            display: block;
            width: 50px;
            height: 3px;
            background-color: #4CAF50;
            margin: 6px auto 0;
            border-radius: 2px;
        }

        .form-container {
            max-width: 600px;
            margin: 0 auto;
            padding: 25px;
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }

        form label {
            display: block;
            margin-bottom: 6px;
            font-weight: bold;
            color: #333;
            margin-top: 15px;
        }

        form input[type="text"] {
            width: 100%;
            padding: 10px 12px;
            border: 1px solid #ccc;
            border-radius: 6px;
            box-sizing: border-box;
            transition: border-color 0.3s ease;
        }

        form input[type="text"]:focus {
            border-color: #4CAF50;
            outline: none;
        }

        form input[type="submit"] {
            margin-top: 20px;
            width: 100%;
            padding: 12px;
            background-color: #28a745;
            color: #fff;
            border: none;
            border-radius: 6px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        form input[type="submit"]:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
<h1>Create new Movie</h1>
<div class="form-container">
    <form action="<%=request.getContextPath()%>/MovieServlet?action=Create" method="post">
        <select>

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
</div>
</body>
</html>
