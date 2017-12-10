<%@ page import="sdatwitter.servlets.UserServlet" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="utf-8" %>
<html>
<head>
    <title>Registration Form</title>
</head>
<body>
<%
    String error = request.getParameter("error");
    if (error != null && "".equals(error)){
        out.println("Brak autora i/lub wpisu.");
    }

    String author = "";
    for (Cookie cookie: request.getCookies()
            ) {
        if (UserServlet.AUTHOR_COOKIE.equals(cookie.getName())){
            author = cookie.getValue();
        }
    }
%>
<form action="/index" method="post">
    Sign in if you don't have an account.
    <br>
    <ul>
        <li>Nick: <input name="Nick" type="text" value="<%= author %>"></li>
        <li>Password: <input name="Password" type="text"></li>
        <li>Confirm password: <input name="ConfirmPassword" type="text"></li>

    </ul>
    <input type="submit" value="Register">
<br>
<br>
    Or Login if you have an account.

    <ul>
        <li>Nick: <input name="Nick" type="text"></li>
        <li>Password: <input name="Password" type="text"></li>

    </ul>
<input type="submit" value="Login">

</form>



</body>
</html>