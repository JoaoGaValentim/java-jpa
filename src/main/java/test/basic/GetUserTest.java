package test.basic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.basic.User;

public class GetUserTest {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java-jpa");
        EntityManager em = emf.createEntityManager();

        User user = em.find(User.class, 1L);

        System.out.println(user.getName());
        System.out.println(user.getEmail());

        em.close();
        emf.close();
    }
}
