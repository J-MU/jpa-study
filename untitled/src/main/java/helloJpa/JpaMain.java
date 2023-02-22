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
            System.out.println("뭐고 이거");
            Member member1=em.find(Member.class,1L);
            Member member2=em.find(Member.class,2L);
            Date date=new Date();
            Order order1=new Order(date, OrderStatus.ORDER,member1);
            Order order2=new Order(date, OrderStatus.ORDER,member2);
            em.persist(order1);
            em.persist(order2);

            Item item1=new Item("책1",100,3);
            Item item2=new Item("책2",100,2);
            Item item3=new Item("책3",100,1);
            em.persist(item1);
            em.persist(item2);
            em.persist(item3);

            OrderItem orderItem1=new OrderItem();
            OrderItem orderItem2=new OrderItem();
            OrderItem orderItem3=new OrderItem();

            orderItem1.setOrder(order1);
            orderItem1.setItem(item1);
            orderItem2.setOrder(order1);
            orderItem2.setItem(item2);
            orderItem3.setOrder(order2);
            orderItem3.setItem(item3);

            em.persist(orderItem1);
            em.persist(orderItem2);
            em.persist(orderItem3);
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
