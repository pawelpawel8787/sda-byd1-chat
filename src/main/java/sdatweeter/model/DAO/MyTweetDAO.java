package sdatweeter.model.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sdatweeter.model.MyTweet;
import sdatweeter.utility.HibernateUtil;


public class MyTweetDAO {

    public Integer addMyTweet(MyTweet myTweet) {

        Session session = HibernateUtil.getHibernateSession().getSessionFactory().openSession();
        Transaction tx = null;
        Integer myTweetID = null;

        try {
            tx = session.beginTransaction();
            myTweetID = (Integer)session.save(myTweet);
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return myTweetID;
    }


}
