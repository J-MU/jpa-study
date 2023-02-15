package helloJpa;

import org.h2.mvstore.tx.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("hello");
        EntityManager em=emf.createEntityManager();

        EntityTransaction tx=em.getTransaction();   //transaction이란 뭐지? transaction범위를 최소화 해줘야하는 이유는?
        tx.begin();
        //code
        try{
            Member memberA=new Member("이안");
            Member memberB=new Member("민욱");
            Member memberC=new Member("제제");
            em.persist(memberA);
            em.persist(memberB);
            em.persist(memberC);


            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally{
            em.close();
        }
        emf.close();
    }
}
