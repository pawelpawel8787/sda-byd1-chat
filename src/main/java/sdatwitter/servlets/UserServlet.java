package sdatwitter.servlets;

import com.google.common.base.Strings;
import sdatwitter.model.DAO.UserDAO;
import sdatwitter.model.User;
import sdatwitter.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloTweetService", value = "/index")
public class UserServlet extends HttpServlet {

    public static final String AUTHOR_COOKIE = "author-cookie";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nick = (String) req.getParameter("Nick");
        String pass = (String) req.getParameter("Password");

        if (Strings.isNullOrEmpty(nick) && Strings.isNullOrEmpty(pass)) {

            resp.sendRedirect("/publish.jsp?error");
        } else {

            UserDAO userDAO = new UserDAO();
            User user1 = new User();
            user1.setNick(nick);
            user1.setPass(pass);

            userDAO.addUser(user1);
        }
    }
}



