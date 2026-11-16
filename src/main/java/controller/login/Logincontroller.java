package controller.login;

import entity.Login;
import model.LoginDTO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.Hibernateutil;

public class Logincontroller {


    public boolean nameandpasswordcheck(LoginDTO loginDTO) {

        Session session = Hibernateutil.getSessionFactory().openSession();

        String HQL = "FROM Login l WHERE l.username = : userName AND l.password = :password";


        try {

            Login login = session.createQuery(HQL, Login.class)
                    .setParameter("userName",loginDTO.getUserName())
                    .setParameter("password",loginDTO.getPassword())
                    .uniqueResult();
                if (login.getUsername().equals(loginDTO.getUserName()) && (login.getPassword().equals(loginDTO.getPassword()))) {
                    return true;
                }

            return false;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
