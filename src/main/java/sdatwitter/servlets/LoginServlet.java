package sdatwitter.servlets;

import com.google.common.base.Strings;
import sdatwitter.model.DAO.UserDAO;
import sdatwitter.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "dsdsd", value = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nick = (String) req.getParameter("LoginNick");
        String pass = (String) req.getParameter("LoginPassword");

        UserDAO userDAO = new UserDAO();


        boolean flag = false;

        if (nick.trim().length() >= 0 && nick != null &&
                pass.trim().length() >= 0 && pass != null) {

            List<User> usersList = userDAO.getUserByNickAndPassword(nick, pass);
            for (User result : usersList
                    ) {
                boolean correctNick = result.getNick().contentEquals(nick);
                boolean correctPassword = result.getPass().contentEquals(pass);

                if (correctNick && correctPassword) {
                    flag = true;

                    Cookie cookie = new Cookie("nick-cookie", nick);
                    cookie.setMaxAge(900);
                    resp.addCookie(cookie);
                    String redirectURL = "/twitterMessage.jsp";
                    resp.sendRedirect(redirectURL);
                }
            }
        }
        if (flag == false) {
            resp.sendRedirect("/login.jsp?error");
        }


    }


}


