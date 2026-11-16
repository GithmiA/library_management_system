package controller.login;

import entity.Login;
import model.LoginDTO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.Hibernateutil;

public class Signupcontroller {


    public void saveDetails(LoginDTO loginDTO) {

        Session session = Hibernateutil.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        try {
            Login login = new Login();
            login.setUsername(loginDTO.getUserName());
            login.setPassword(loginDTO.getPassword());

            session.persist(login);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Sign up failed",e);
        }

    }
}
