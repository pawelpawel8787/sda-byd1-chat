package sdatwitter.servlets;

import com.google.common.base.Strings;
import sdatwitter.model.DAO.UserDAO;
import sdatwitter.model.User;

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
        String confirmPass = (String) req.getParameter("ConfirmPassword");

        if (Strings.isNullOrEmpty(nick) && Strings.isNullOrEmpty(pass) && Strings.isNullOrEmpty(confirmPass)) {

            //resp.sendRedirect("/publish.jsp?error");
        } else {

            UserDAO userDAO = new UserDAO();
            User user1 = new User();
            user1.setNick(nick);
            if (!(pass.equals(confirmPass))) {
                resp.getWriter().println("Podane hasła się nie zgadzają.");

            }else{
                user1.setPass(pass);
                userDAO.addUser(user1);
                resp.sendRedirect("/index.jsp");
            }
        }
    }
}



