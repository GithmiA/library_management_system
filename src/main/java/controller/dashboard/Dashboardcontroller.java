package controller.dashboard;

import org.hibernate.Session;
import util.Hibernateutil;

public class Dashboardcontroller {

    Session session = Hibernateutil.getSessionFactory().openSession();

    public Long countMembers() {

        return session.createQuery("SELECT COUNT(m) FROM Member m", Long.class)
                .getSingleResult();
    }

    public Long countBooks() {

        return session.createQuery("SELECT COUNT(m) FROM Book m", Long.class)
                .getSingleResult();
    }

    public Long countCurrentlyBorrowing() {

        return session.createQuery("SELECT COUNT(m) FROM Borrowing m WHERE m.status = :status", Long.class)
                .setParameter("status","Borrowed")
                .getSingleResult();

    }

    public Long countOverdueBooks() {

        return session.createQuery("SELECT COUNT(m) FROM Borrowing m WHERE m.status = :status", Long.class)
                .setParameter("status","Overdue")
                .getSingleResult();
    }
}
