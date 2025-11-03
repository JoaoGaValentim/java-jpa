package test.basic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.basic.User;

public class UpdateUserTestOne {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java-jpa");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        User user = em.find(User.class, 4L);
        user.setName("Heloisa Valentim Theodoro");

        em.merge(user); // update
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
