package controller.books;

import entity.Book;
import entity.Borrowing;
import entity.Member;
import model.BorrowingDTO;
import org.hibernate.Session;
import util.Hibernateutil;

public class Returnbookcontroller {

    public BorrowingDTO load(String bookId) {

        Session session = Hibernateutil.getSessionFactory().openSession();

        try {
            Borrowing borrowing = session.createQuery("FROM Borrowing b WHERE b.book_id = :id" + "AND b.returndate = :returndate",Borrowing.class)
                    .setParameter("id",bookId)
                    .setParameter("returndate"," - ")
                    .setMaxResults(1)
                    .uniqueResult();
            if (borrowing != null) {
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
}
