package businessLogic;

import org.hibernate.SessionFactory;

public class DbConnectionProvider {

    private static final SessionFactory sessionFactory = buildSessionFactory();


    private static SessionFactory buildSessionFactory() {
        try {
            return DefaultConfigurationHolder.getConfiguration().buildSessionFactory();
        } catch (Throwable e) {
            throw new RuntimeException("Connection failed!" + e);
        }
    }


    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
