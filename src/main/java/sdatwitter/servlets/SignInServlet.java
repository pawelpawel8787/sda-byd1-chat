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

@WebServlet(name = "assds", value = "/signIn")
public class SignInServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nick = (String) req.getParameter("SignInNick");
        String pass = (String) req.getParameter("SignInPassword");
        String confirmPass = (String) req.getParameter("SignInConfirmPassword");

        if (Strings.isNullOrEmpty(nick) && Strings.isNullOrEmpty(pass) && Strings.isNullOrEmpty(confirmPass)) {
        } else {

            UserDAO userDAO = new UserDAO();

            User user1 = new User();
            user1.setNick(nick);
            if (!(pass.equals(confirmPass))) {
                resp.getWriter().println("Podane hasła się nie zgadzają.");

            }else{
                user1.setPass(pass);
                userDAO.addUser(user1);
                resp.sendRedirect("/twitterMessage.jsp");
            }
        }
    }
}
