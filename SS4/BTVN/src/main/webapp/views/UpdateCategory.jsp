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
            color: #333;
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

        input[type="radio"] {
            margin-top: 10px;
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
<h3>Update Catalog</h3>
<form action="<%=request.getContextPath()%>/CategoryController?action=Update" method="post">
    <label for="id">ID</label>
    <input type="text" id="id" name="id" value="${category.id}" readonly/><br>
    <label for="cateName">Name</label>
    <input type="text" id="cateName" name="cateName" value="${category.cateName}"/><br>
    <label for="description">Description</label>
    <input type="text" id="description" name="description" value="${category.description}"/><br>
    <label for="active">Status</label>
    <label for="active">Active</label><input type="radio" id="active" name="status" value="true" ${category.status?"checked":""}/>
    <label for="inActive">InActive</label><input type="radio" id="inActive" name="status" value="false" ${category.status?"":"checked"}/><br>
    <input type="submit" value="Update"/>
</form>
</body>
</html>
