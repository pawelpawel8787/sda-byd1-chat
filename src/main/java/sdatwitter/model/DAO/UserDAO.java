package sdatwitter.model.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import sdatwitter.model.User;
import sdatwitter.utility.HibernateUtil;

import java.util.Collections;
import java.util.List;

import static jdk.nashorn.internal.parser.TokenType.AND;


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

    public List<User> getUserByNickAndPassword(String nick, String pass) {
        Session session = HibernateUtil.getHibernateSession().getSessionFactory().openSession();
        List result = null;
        try {
            session.beginTransaction();
            String hql = "FROM User WHERE nick = :nick AND pass = :pass";
            Query query = session.createQuery(hql);
            query.setParameter("nick", nick);
            query.setParameter("pass", pass);
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

    public List<User> getUserIdFromItsNick(String nick) {
        Session session = HibernateUtil.getHibernateSession().getSessionFactory().openSession();
        List result = null;
        try {
            session.beginTransaction();
            String hql = "FROM User WHERE user_id = :nick";
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

    public List<User> getUserList() {
        Session session = HibernateUtil.getHibernateSession().getSessionFactory().openSession();

        session.beginTransaction();
        List<User> users = session.createQuery("FROM User").list();
        session.getTransaction().commit();

        session.close();

        return users;
    }

}