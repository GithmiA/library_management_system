package controller.members;

import entity.Member;
import model.MemberDTO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.Hibernateutil;

public class Addmembercontroller {

    Session session = Hibernateutil.getSessionFactory().openSession();

    public void addMember(MemberDTO memberDTO) {

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            Member member = new Member(
                    memberDTO.getMemberId(),
                    memberDTO.getFullName(),
                    memberDTO.getEmail(),
                    memberDTO.getPhoneNumber(),
                    memberDTO.getAddress()
            );
            session.persist(member);
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
