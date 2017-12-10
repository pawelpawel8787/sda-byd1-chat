package sdatweeter;


import org.hibernate.Session;
import org.hibernate.type.TimestampType;
import sdatweeter.model.MyTweet;
import sdatweeter.model.User;
import sdatweeter.utility.HibernateUtil;


public class Main {

    public static void main(String[] args) {


        Session session = HibernateUtil.getHibernateSession();

        User user1 = new User();
        MyTweet myTweet1 = new MyTweet();

        user1.setNick("Janek");
        user1.setPass("Klocek");

        myTweet1.setMessage("Ala ma kota");
        myTweet1.setTimestamp(System.currentTimeMillis());

        session.beginTransaction();
        session.save(user1);

        myTweet1.setUser(user1);
        session.save(myTweet1);

        session.getTransaction().commit();

        session.close();
        HibernateUtil.closeSession();

    }
}