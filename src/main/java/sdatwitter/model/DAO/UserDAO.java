package sdatwitter.model.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sdatwitter.model.User;
import sdatwitter.utility.HibernateUtil;


public class UserDAO {

    public Integer addUser(User user) {

        Session session = HibernateUtil.getHibernateSession().getSessionFactory().openSession();
        Transaction tx = null;
        Integer userID = null;

        try {
            tx = session.beginTransaction();
            userID = (Integer) session.save(user);
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();

        }
        return userID;
    }

    public User findUser(int id) {
        Session session = HibernateUtil.getHibernateSession().getSessionFactory().openSession();
        User user = null;
        try {
            session.beginTransaction();
            user = session.get(User.class, id);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();


        }
        return user;
    }
}