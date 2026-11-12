package controller.books;

import entity.Book;
import model.BookDTO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.Hibernateutil;

public class Addbookcontroller {

    Session session = Hibernateutil.getSessionFactory().openSession();

    public void saveBook(BookDTO bookDTO) {

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Book book = new Book(
                    bookDTO.getBookId(),
                    bookDTO.getBookTitle(),
                    bookDTO.getBookAuthor(),
                    bookDTO.getBookCategory(),
                    bookDTO.getBookPublishYear(),
                    bookDTO.getBookQuantity()
            );
            session.persist(book);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Book Saving failed",e);
        } finally {
            session.close();
        }
    }
}
