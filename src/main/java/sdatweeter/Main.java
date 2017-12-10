package sdatweeter;


import org.hibernate.Session;
import org.hibernate.type.TimestampType;
import sdatweeter.model.DAO.MyTweetDAO;
import sdatweeter.model.DAO.UserDAO;
import sdatweeter.model.MyTweet;
import sdatweeter.model.User;
import sdatweeter.utility.HibernateUtil;


public class Main {

    public static void main(String[] args) {


        //Session session = HibernateUtil.getHibernateSession();

//
 //       MyTweetDAO myTweetDAO = new MyTweetDAO();
//        UserDAO userDAO = new UserDAO();
//        User user1 = new User();
//        MyTweet myTweet1 = new MyTweet();
//
//        user1.setNick("Janek");
//        user1.setPass("Klocek");
//
//
//        myTweet1.setMessage("Ala ma kota");
//        myTweet1.setTimestamp(System.currentTimeMillis());
//
//        myTweet1.setUser(user1);
//
//        userDAO.addUser(user1);
//        myTweetDAO.addMyTweet(myTweet1);
        HibernateUtil.closeSession();

    }
}