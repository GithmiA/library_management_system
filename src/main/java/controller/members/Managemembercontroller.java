package controller.members;

import entity.Book;
import entity.Borrowing;
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
           List <Member> memberList = session.createQuery("FROM Member", Member.class).getResultList();

                for(Member member : memberList) {
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

        Session session = Hibernateutil.getSessionFactory().openSession();

        String HQL ="SELECT COUNT(b) FROM Borrowing b WHERE b.memberId = :member";

        try {
            Long count = session.createQuery(HQL, Long.class)
                    .setParameter("member",member.getMemberId())
                    .uniqueResult();
            return count != null && count > 0;
        } catch (Exception e) {
            throw new RuntimeException("Failed to check borrowing records",e);
        }
    }

    public boolean deleteMember(MemberDTO member) {

        Session session = Hibernateutil.getSessionFactory().openSession();

        try {
            Transaction transaction = session.beginTransaction();

           Member member1 = session.createQuery("FROM Member m WHERE m.memberId = :memberid", Member.class)
                    .setParameter("memberid",member.getMemberId())
                    .uniqueResult();
           if (member1 != null) {
               session.remove(member1);
               transaction.commit();
               return true;
           }
           transaction.rollback();
           return false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
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

    public ObservableList<MemberDTO> searchDate(String searchId) {

        Session session = Hibernateutil.getSessionFactory().openSession();

        String HQL = "FROM Member m WHERE m.memberId = :member";

        ObservableList<MemberDTO> list = FXCollections.observableArrayList();

        try {
            List<Member> memberList = session.createQuery(HQL, Member.class)
                    .setParameter("member",searchId)
                    .getResultList();

            for (Member member : memberList) {
                MemberDTO memberDTO = new MemberDTO();

                memberDTO.setMemberId(member.getMemberId());
                memberDTO.setFullName(member.getFullName());
                memberDTO.setEmail(member.getEmail());
                memberDTO.setPhoneNumber(member.getPhoneNumber());

                list.add(memberDTO);
            }

           return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
