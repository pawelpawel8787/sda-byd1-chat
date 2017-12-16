package sdatwitter.model.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import sdatwitter.model.MyTwitter;
import sdatwitter.model.User;
import sdatwitter.utility.HibernateUtil;

import java.util.List;


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

    public List<MyTwitter> getTweetList() {
        Session session = HibernateUtil.getHibernateSession().getSessionFactory().openSession();

        session.beginTransaction();
        List<MyTwitter> twitterList = session.createQuery("FROM MyTwitter ").list();
        session.getTransaction().commit();

        session.close();

        return twitterList;
    }

    public List<MyTwitter> getSelectedUserTweets(int nick) {
        Session session = HibernateUtil.getHibernateSession().getSessionFactory().openSession();
        List result = null;
        try {
            session.beginTransaction();
            String hql = "FROM MyTwitter WHERE user.user_id = :nick";
            Query query = session.createQuery(hql);
            query.setParameter("nick", nick);
            result = query.getResultList();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        }

        return result;

    }


}
