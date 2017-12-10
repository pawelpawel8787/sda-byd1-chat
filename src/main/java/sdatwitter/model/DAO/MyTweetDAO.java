package sdatwitter.model.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sdatwitter.model.MyTwitter;
import sdatwitter.utility.HibernateUtil;


public class MyTweetDAO {

    public Integer addMyTweet(MyTwitter myTwitter) {

        Session session = HibernateUtil.getHibernateSession().getSessionFactory().openSession();
        Transaction tx = null;
        Integer myTweetID = null;

        try {
            tx = session.beginTransaction();
            myTweetID = (Integer)session.save(myTwitter);
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
