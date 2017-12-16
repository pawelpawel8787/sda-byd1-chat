<%@ page import="sdatwitter.servlets.UserServlet" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="utf-8" %>
<html>
<head>
    <title>Registration Form</title>
</head>
<body>

<form action="/signIn.jsp">
    <input type="submit" value="SIGN IN"
           STYLE="font: 8pt Arial; font-style: italic; font-weight: bold; font-size: large; color:yellow; background:green; width:100px; height:50px;"/>
</form>
<br>
<form action="/login.jsp">
    <input type="submit" value="LOG IN"
           STYLE="font: 8pt Arial; font-style: italic; font-weight: bold; font-size: large; color:yellow; background:green; width:100px; height:50px;"/>
</form>

</body>
</html>