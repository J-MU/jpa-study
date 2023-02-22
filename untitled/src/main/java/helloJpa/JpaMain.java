package helloJpa;


import helloJpa.data.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("hello");
        EntityManager em=emf.createEntityManager();

        EntityTransaction tx=em.getTransaction();   //transaction이란 뭐지? transaction범위를 최소화 해줘야하는 이유는?
        tx.begin();
        //code
        try{
            Member member1=new Member("이안");
            Team team1=new Team("이안팀");

//            member1.setTeam(team1);
            team1.addMember(member1);
            tx.commit();
        }catch (Exception e){
            System.out.println(e);
            tx.rollback();
        }finally{
            em.close();
        }
        emf.close();
    }
}
