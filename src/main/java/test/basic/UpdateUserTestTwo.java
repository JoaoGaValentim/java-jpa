package test.basic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.basic.User;

public class UpdateUserTestTwo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java-jpa");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // estado gerenciado
        // tudo que você faz com esse objeto ness contexto
        // sincroniza a mudança com o banco de dados
        // trabalhar de forma não gerenciada é melhor
        User user = em.find(User.class, 4L);
        user.setName("Heloisa Gabriela Valentim Theodoro");

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
