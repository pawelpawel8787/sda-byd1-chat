package sdatweeter.utility;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private final static SessionFactory sf = new Configuration().configure().buildSessionFactory();

    private static Session session = sf.openSession();

    private HibernateUtil() {
    }

    public static Session getHibernateSession() {
        if (session == null) {
            session = (Session) new HibernateUtil();
        }
        return session;
    }

    public static void closeSession() throws HibernateException {
        sf.close();
    }

}
