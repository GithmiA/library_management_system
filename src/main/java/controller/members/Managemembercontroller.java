package controller.members;

import entity.Book;
import entity.Member;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.MemberDTO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.Hibernateutil;

import java.util.List;

public class Managemembercontroller {

    public ObservableList<MemberDTO> loadTable() {

        Session session = Hibernateutil.getSessionFactory().openSession();

        ObservableList<MemberDTO> members = FXCollections.observableArrayList();

        try {
            Member member = session.createQuery("FROM Member", Member.class).uniqueResult();

            if (member != null) {
                MemberDTO memberDTO = new MemberDTO();

                memberDTO.setMemberId(member.getMemberId());
                memberDTO.setFullName(member.getFullName());
                memberDTO.setEmail(member.getEmail());
                memberDTO.setPhoneNumber(member.getPhoneNumber());

                members.add(memberDTO);
            }
            return members;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public boolean hasBorrowingRecords(MemberDTO member) {
        return false;
    }

    public boolean deleteMember(MemberDTO member) {
        return false;
    }

    public void updateMember(MemberDTO member) {

        Session session = Hibernateutil.getSessionFactory().openSession();

        String HQL = "FROM Member m WHERE m. ";

        Transaction transaction = session.beginTransaction();



    }
}
