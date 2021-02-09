package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.transaction.Transaction;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        //실제 동작하는 코드를 작성해줌
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{


            Child child1 = new Child();
            Child child2 = new Child();


            Parent parent = new Parent();

            parent.addChild(child1);
            parent.addChild(child2);

            em.persist(parent);
            em.flush();
            em.clear();
            Parent findParent = em.find(Parent.class, parent.getId());
            findParent.getChildList().remove(0);
//            em.persist(child1); //지우면 에러
//            em.persist(child2);



            tx.commit();
        }catch(Exception e){
            tx.rollback();
//            e.printStackTrace();
        }finally{
            em.close();
        }
        emf.close();


    }

}
