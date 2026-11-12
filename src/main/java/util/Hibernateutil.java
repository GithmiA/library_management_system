package util;

import entity.Book;
import entity.Member;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibernateutil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration()
                    .setProperty("hibernate.connection.url","jdbc:mysql://localhost:3306/librarydb?createDatabaseIfNotExist=true")
                    .setProperty("hibernate.connection.username","root")
                    .setProperty("hibernate.connection.password","12345")
                    .setProperty("hibernate.hbm2ddl.auto","update")
                    .addAnnotatedClass(Book.class)
                    .addAnnotatedClass(Member.class);

            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
