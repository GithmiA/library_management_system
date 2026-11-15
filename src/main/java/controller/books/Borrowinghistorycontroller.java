package controller.books;

import entity.Borrowing;
import entity.Member;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.BorrowingDTO;
import org.hibernate.Session;
import util.Hibernateutil;

import java.util.List;

public class Borrowinghistorycontroller {

    public ObservableList<BorrowingDTO> loadDetails() {

        Session session = Hibernateutil.getSessionFactory().openSession();

        String HQL = "FROM Borrowing";

        ObservableList<BorrowingDTO> borrowingList = FXCollections.observableArrayList();

        try {

            List<Borrowing> borrowings = session.createQuery(HQL, Borrowing.class)
                    .getResultList();

            for(Borrowing borrowing : borrowings) {
                BorrowingDTO borrowingDTO = new BorrowingDTO();
                borrowingDTO.setMemberId(borrowing.getMemberId());
                borrowingDTO.setBookTitle(borrowing.getBookTitle());
                borrowingDTO.setIssueDate(borrowing.getIssueDate());
                borrowingDTO.setDueDate(borrowing.getDueDate());
                borrowingDTO.setReturnDate(borrowing.getReturnDate());
                borrowingDTO.setStatus(borrowing.getStatus());

                borrowingList.add(borrowingDTO);
            }
            return borrowingList;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    public ObservableList<BorrowingDTO> searchData(String searchId) {
//    }
}
