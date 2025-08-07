<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        form select {
            width: 100%;
            padding: 10px 12px;
            border: 1px solid #ccc;
            border-radius: 6px;
            box-sizing: border-box;
            transition: border-color 0.3s ease;
        }

        form select:focus {
            border-color: #4CAF50;
            outline: none;
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

        form input[type="datetime-local"] {
            width: 100%;
            padding: 10px 12px;
            border: 1px solid #ccc;
            border-radius: 6px;
            box-sizing: border-box;
            transition: border-color 0.3s ease;
        }
        form input[type="datetime-local"]:focus {
            border-color: #4CAF50;
            outline: none;
        }
    </style>
</head>
<body>
<h1>Add New Schedule</h1>
<div class="form-container">
    <form action="<%=request.getContextPath()%>/ScheduleServlet?action=Create" method="post">
        <label for="movieId">Movie</label>
        <select id="movieId" name="movieId" required>
            <option value="">-- Select Movie --</option>
            <c:forEach var="movie" items="${movieList}">
                <option value="${movie.id}">${movie.title}</option>
            </c:forEach>
        </select>

        <label for="showTime">Show Time</label>
        <input type="datetime-local" id="showTime" name="showTime" required/>

        <label for="screenRoomId">Screen Room</label>
        <select id="screenRoomId" name="screenRoomId" required>
            <option value="">-- Select Room --</option>
            <c:forEach var="room" items="${screenRoomList}">
                <option value="${room.id}">${room.screenRoomName}</option>
            </c:forEach>
        </select>

        <label for="availableSeats">Available Seats</label>
        <input type="text" id="availableSeats" name="availableSeats" required/>

        <label for="format">Format</label>
        <input type="text" id="format" name="format" required/>

        <input type="submit" value="Add Schedule"/>
    </form>
</div>
</body>
</html>
