<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            background-color: #fff3f3;
            font-family: Arial, sans-serif;
            display: flex;
            flex-direction: column;
            align-items: center;
            padding-top: 100px;
        }

        h1 {
            color: #d9534f;
            font-size: 28px;
            margin-bottom: 20px;
        }

        a {
            text-decoration: none;
            color: white;
            background-color: #0275d8;
            padding: 10px 20px;
            border-radius: 5px;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }

        a:hover {
            background-color: #025aa5;
        }
    </style>
</head>
<body>
<h1>Có lỗi xảy ra trong quá trình thêm mới</h1>
<a href="${pageContext.request.contextPath}/student">Quay lại danh sách</a>
</body>
</html>
