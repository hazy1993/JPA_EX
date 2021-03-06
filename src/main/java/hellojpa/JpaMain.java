package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.transaction.Transaction;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        //실제 동작하는 코드를 작성해줌
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

           Member member = new Member();
           member.setUsername("member1");
           member.setHomeAddress(new Address("homeCity","street","10000"));
           member.getFavoriteFoods().add("치킨");
           member.getFavoriteFoods().add("족발");
           member.getFavoriteFoods().add("피자");

           member.getAddressHistory().add(new Address("old1","street","10000"));
           member.getAddressHistory().add(new Address("old2","street","10000"));


            em.persist(member);
            em.flush();
            em.clear();

            System.out.println("===========START============");
            Member findMember = em.find(Member.class, member.getId());
            List<Address> addressHistory = findMember.getAddressHistory();
            for (Address address : addressHistory) {
                System.out.println("address = " + address.getCity());
            }

            Set<String> favoriteFoods = findMember.getFavoriteFoods();
            for (String favoriteFood : favoriteFoods) {
                System.out.println("favoriteFoods = " + favoriteFood);
            }

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
