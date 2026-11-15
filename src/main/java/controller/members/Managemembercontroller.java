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

    public boolean updateMember(MemberDTO member) {

        Session session = Hibernateutil.getSessionFactory().openSession();

        String HQL = "FROM Member m WHERE m.memberId = :member";

        Transaction transaction = session.beginTransaction();

        try {
          Member member1 = session.createQuery(HQL, Member.class)
                    .setParameter("member",member.getMemberId())
                    .uniqueResult();
          if (member1 != null) {
              member1.setFullName(member.getFullName());
              member1.setEmail(member.getEmail());
              member1.setPhoneNumber(member1.getPhoneNumber());
              transaction.commit();
              return true;
          }
          transaction.rollback();
          return false;
        } catch (Exception e) {
            throw new RuntimeException("Member Update failed!",e);
        }



    }
}
