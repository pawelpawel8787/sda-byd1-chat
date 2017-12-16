<%@ page import="com.google.common.base.Strings" %>
<%@ page import="sdatwitter.model.MyTwitter" %>
<%@ page import="sdatwitter.model.DAO.MyTweetDAO" %>
<%@ page import="sdatwitter.model.User" %>
<%@ page import="sdatwitter.model.DAO.UserDAO" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="utf-8" %>
<html>
<body>
<%
    String userNickname = "";
    int value = 0;

    for (Cookie cookie : request.getCookies()) {
        if ("nick-cookie".equals(cookie.getName())) {
            userNickname = cookie.getValue();
        }
    }
    UserDAO userDAO = new UserDAO();

    for (User result : userDAO.getUserList()
            ) {
        if (result.getNick().equals(userNickname)) {
            value = result.getUser_id();
        }
    }
%>

<table border="1">
    <tr>
        <th width="100">Author</th>
        <th width="100">Date</th>
        <th width="300">Message</th>


    </tr>
    <%


        MyTweetDAO service = new MyTweetDAO();
        for (MyTwitter tweetList : service.getSelectedUserTweets(value)
                ) {
            out.print("<tr>");
            out.println("<td>" + tweetList.getUser().getNick() + "</td>");
            out.println("<td>" + tweetList.getMessage() + "</td>");
            out.println("<td>" + tweetList.getTimestamp() + "</td>");
            out.print("</tr>");
        }
    %>

</table>


</body>
</html>