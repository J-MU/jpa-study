package helloJpa;

import org.h2.mvstore.tx.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("hello");
        EntityManager em=emf.createEntityManager();

        EntityTransaction tx=em.getTransaction();   //transaction이란 뭐지? transaction범위를 최소화 해줘야하는 이유는?
        tx.begin();
        //code
        try{
            Member member=new Member();
            member.setId(3L);
            member.setName("제제");
            member.setRoleType(RoleType.GUEST);

            em.persist(member);
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally{
            em.close();
        }
        emf.close();
    }
}
