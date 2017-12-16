<%@ page import="sdatwitter.servlets.UserServlet" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2017-12-12
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign In</title>
</head>
<body>
<%
    String error = request.getParameter("error");
    if (error != null && "".equals(error)) {
        out.println("Brak autora i/lub wpisu.");
    }

    String author = "";
    for (Cookie cookie : request.getCookies()
            ) {
        if (UserServlet.AUTHOR_COOKIE.equals(cookie.getName())) {
            author = cookie.getValue();
        }
    }
%>

<form action="/signIn" method="post">

    <br>
    <ul>
        <li>Nick: <input name="SignInNick" type="text" value="<%= author %>"></li>
        <li>Password: <input name="SignInPassword" type="text"></li>
        <li>Confirm password: <input name="SignInConfirmPassword" type="text"></li>

    </ul>

    <input type="submit" value="Register">
    <br>
</form>

</body>
</html>
