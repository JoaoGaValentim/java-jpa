package test.basic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.basic.User;

public class UpdateTestThree {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java-jpa");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        User user = em.find(User.class, 6L);
        // trabalhar de forma não gerenciada é melhor
        em.detach(user); // tirar do contexto

        user.setName("X");
        user.setEmail("x@gmail.com");

        em.merge(user); // explicito
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
