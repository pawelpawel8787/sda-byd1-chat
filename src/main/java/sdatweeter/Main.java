package sdatweeter;


import org.hibernate.Session;
import sdatweeter.model.MyTweet;
import sdatweeter.model.User;
import sdatweeter.utility.HibernateUtil;

public class Main {

    public static void main(String[] args) {


        Session session = HibernateUtil.getHibernateSession();

        User user1 = new User();
        user1.setNick("Janek");
        user1.setPass("Klocek");

        MyTweet myTweet = new MyTweet();

        myTweet.setMessage("Ala ma kota");

        session.beginTransaction();
        session.save(user1);

        myTweet.setUser(user1);
        session.save(myTweet);

        session.getTransaction().commit();

        session.close();
        HibernateUtil.closeSession();

    }
}