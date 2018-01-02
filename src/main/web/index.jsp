<%@ page import="mypack.HelloWorld" %>
<%@ page session="false" %><%--
<%@ page import="Sample.MySQLConnect" %>
  Created by IntelliJ IDEA.
  User: Danny
  Date: 12/18/2017
  Time: 4:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Room Booking</title>
</head>
<body>
<h3><%=HelloWorld.getMessage()%></h3>
<h1>Room Reservations</h1>
<a href="login.html">Login</a> |
<%--<a href="LogoutServlet">Logout</a> |--%>
<a href="ProfileServlet">Profile</a>
<p></p>
</body>
</html>