package sdatwitter;


import sdatwitter.model.DAO.MyTweetDAO;
import sdatwitter.model.DAO.UserDAO;
import sdatwitter.model.MyTwitter;
import sdatwitter.model.User;
import sdatwitter.utility.HibernateUtil;


public class Main {

    public static void main(String[] args) {


        //Session session = HibernateUtil.getHibernateSession();


//        MyTweetDAO myTweetDAO = new MyTweetDAO();
//        UserDAO userDAO = new UserDAO();
//        User user1 = new User();
//        MyTwitter myTweet1 = new MyTwitter();
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