package sdatwitter.servlets;


import com.google.common.base.Strings;
import sdatwitter.model.DAO.MyTweetDAO;
import sdatwitter.model.DAO.UserDAO;
import sdatwitter.model.MyTwitter;
import sdatwitter.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TweeterService", value = "/twitterMessage")
public class TwitterServlet extends HttpServlet{

    private MyTweetDAO myTweetDAO = new MyTweetDAO();
    private UserDAO userDAO = new UserDAO();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        MyTwitter myTwitter = new MyTwitter();
        String message = (String) req.getParameter("message");
        String userNickname = "";

        for (Cookie cookie : req.getCookies()) {
            if ("nick-cookie".equals(cookie.getName())) {
                userNickname = cookie.getValue();
            }
        }

        if (Strings.isNullOrEmpty(message)) {
            resp.getWriter().println("Nic nie wpisałeś...");
        }else {
            User userTweets = new User();
            for (User result : userDAO.getUserList()
                    ) {
                if (result.getNick().equals(userNickname)) {
                    userTweets = result;
                }
            }

            myTwitter.setUser(userTweets);
            myTwitter.setMessage(message);
            myTwitter.setTimestamp(System.currentTimeMillis());
            myTweetDAO.addMyTweet(myTwitter);

            resp.sendRedirect("/twitterList.jsp");
        }
    }

    }


