<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Đặt Vé</title></head>
<body>
<h2>Chọn Ghế</h2>

<form action="TicketServlet" method="post">
  <input type="hidden" name="scheduleId" value="${scheduleId}" />

  <c:forEach var="i" begin="1" end="20">
    <c:set var="seatName" value="${'A' + i}" />
    <c:choose>
      <c:when test="${bookedSeats.contains(seatName)}">
        <label style="color: gray">
          <input type="checkbox" disabled /> ${seatName}
        </label>
      </c:when>
      <c:otherwise>
        <label>
          <input type="checkbox" name="seats" value="${seatName}" /> ${seatName}
        </label>
      </c:otherwise>
    </c:choose>
    <br />
  </c:forEach>

  <button type="submit">Đặt Vé</button>
</form>
</body>
</html>