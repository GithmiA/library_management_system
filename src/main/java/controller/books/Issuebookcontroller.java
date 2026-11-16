package controller.books;

import entity.Book;
import entity.Borrowing;
import entity.Member;
import model.BookDTO;
import model.BorrowingDTO;
import model.MemberDTO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.Hibernateutil;

import java.util.ArrayList;
import java.util.List;

public class Issuebookcontroller {

    public void issueBook(BorrowingDTO borrowingDTO) {

        Session session = Hibernateutil.getSessionFactory().openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Borrowing borrowing = new Borrowing(
                    borrowingDTO.getMemberId(),
                    borrowingDTO.getFullName(),
                    borrowingDTO.getBookId(),
                    borrowingDTO.getBookTitle(),
                    borrowingDTO.getIssueDate(),
                    borrowingDTO.getDueDate(),
                    borrowingDTO.getReturnDate(),
                    borrowingDTO.getStatus()
            );

            session.persist(borrowing);
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

    public List<BookDTO> getAllBooks() {

        Session session = Hibernateutil.getSessionFactory().openSession();

        List<Book> books = session.createQuery("FROM Book", Book.class).getResultList();

        List<BookDTO> bookDTOS = new ArrayList<>();

        for (Book book : books) {
            BookDTO bookDTO = new BookDTO();

            bookDTO.setBookId(book.getBookId());
            bookDTO.setBookTitle(book.getBookTitle());

            bookDTOS.add(bookDTO);
        }
        return bookDTOS;


    }

    public List<MemberDTO> getAllMembers() {

        Session session = Hibernateutil.getSessionFactory().openSession();

        List<Member> members = session.createQuery("FROM Member",Member.class).getResultList();

        List<MemberDTO> memberDTOList = new ArrayList<>();

        for (Member member : members) {
            MemberDTO memberDTO = new MemberDTO();

            memberDTO.setMemberId(member.getMemberId());
            memberDTO.setFullName(member.getFullName());

            memberDTOList.add(memberDTO);
        }
        return memberDTOList;
    }
}
