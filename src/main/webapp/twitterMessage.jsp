
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Twitter Messages</title>
</head>
<body>


<form action="/twitterMessage" method="post">
    <ul>


            <p align="center">
                Message: <br><textarea name="message" style="width: 300px; height: 200px;"></textarea><br>
              <br>
                <input type="submit" name="submit" value="Add tweet"
                       STYLE="font: 8pt Arial; font-style: italic; font-weight: bold; font-size: large; color:yellow; background:green; width:130px; height:50px;"/>
            </p>


    </ul>

</form>

</body>
</html>
