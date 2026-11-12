package controller.books;

import model.BorrowingDTO;
import org.hibernate.Session;
import util.Hibernateutil;

public class Issuebookcontroller {

    Session session = Hibernateutil.getSessionFactory().openSession();

    public void issueBook(BorrowingDTO borrowingDTO) {

    }
}
