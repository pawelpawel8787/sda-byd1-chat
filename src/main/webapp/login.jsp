<%@ page import="sdatwitter.servlets.LoginServlet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    String error = request.getParameter("error");
    if (error != null && "".equals(error)) {
        out.println("Błędny nick i/lub hasło użytkownika.");
    }
%>

<form action="/login" method="post">
    <br>

    <ul>
        <li>Nick: <input name="LoginNick" type="text"></li>
        <li>Password: <input name="LoginPassword" type="text"></li>

    </ul>
    <input type="submit" value="Login">

</form>

</body>
</html>