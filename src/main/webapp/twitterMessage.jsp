<%@ page import="sdatwitter.servlets.LoginServlet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Twitter Messages</title>
</head>
<body>


<form action="/twitterMessage" method="post">
    <ul>


            <p align="center">
                Message: <br><textarea name="message"></textarea><br>
                <input type="submit" name="author">
                <input type="password" name="pass">
                <input type="submit" name="submit" value="Submit">
            </p>


    </ul>
    <input type="submit" value="Submit">
</form>

</body>
</html>
