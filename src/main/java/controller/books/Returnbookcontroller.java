package controller.books;

import entity.Book;
import entity.Borrowing;
import entity.Member;
import model.BorrowingDTO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.Hibernateutil;

import java.time.LocalDate;

public class Returnbookcontroller {

    public BorrowingDTO load(String bookId) {
        LocalDate today = LocalDate.now();

        Session session = Hibernateutil.getSessionFactory().openSession();

        String HQL = "FROM Borrowing b WHERE b.bookId = :id AND b.returnDate = :returndate";
        Transaction transaction = session.beginTransaction();

        try {
            Borrowing borrowing = session.createQuery(HQL,Borrowing.class)
                    .setParameter("id",bookId)
                    .setParameter("returndate"," - ")
                    .uniqueResult();
            if (borrowing != null) {
                if (LocalDate.parse(borrowing.getDueDate()).isBefore(today)) {
                    borrowing.setStatus("Overdue");
                    transaction.commit();

                }
                Member member = session.find(Member.class,borrowing.getMemberId());
                    if(member != null) {
                        BorrowingDTO borrowingDTO = new BorrowingDTO();

                        borrowingDTO.setMemberId(member.getMemberId());
                        borrowingDTO.setFullName(member.getFullName());
                        borrowingDTO.setPhonenumber(member.getPhoneNumber());
                        borrowingDTO.setStatus(borrowing.getStatus());
                        borrowingDTO.setBookTitle(borrowing.getBookTitle());
                        borrowingDTO.setIssueDate(borrowing.getIssueDate());
                        borrowingDTO.setDueDate(borrowing.getDueDate());

                        return borrowingDTO;
                    }
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Book Saving failed",e);
        } finally {
            session.close();
        }

    }

    public boolean returnBook(String returnDate, String bookId) {

        Session session = Hibernateutil.getSessionFactory().openSession();

        String HQL = "FROM Borrowing b WHERE b.bookId = :id AND b.returnDate = :returndate";

        Transaction transaction = session.beginTransaction();

        try {
            Borrowing borrowing = session.createQuery(HQL,Borrowing.class)
                    .setParameter("id",bookId)
                    .setParameter("returndate"," - ")
                    //.setMaxResults(1)
                    .uniqueResult();
            if (borrowing != null) {
                borrowing.setReturnDate(returnDate);
                borrowing.setStatus("Returned");
                transaction.commit();
                return true;
            }
            transaction.rollback();

            return false;
        } catch (Exception e) {
            throw new RuntimeException("Book return failed",e);
        } finally {
            session.close();
        }

    }
}
