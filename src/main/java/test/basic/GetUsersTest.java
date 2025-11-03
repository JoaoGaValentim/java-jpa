package test.basic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import models.basic.User;

public class GetUsersTest {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java-jpa");
        EntityManager em = emf.createEntityManager();

        // jpql trabalha com objetos não tables
        // o hibernate converte o jpql para sql
        // no meu caso estou usando o apelido (name)
        // que dei a classe
        final String jpql = "SELECT u FROM users u";

        // .class é meta-dados
        TypedQuery<User> query = em.createQuery(jpql, User.class);
        List<User> users = query.setMaxResults(10).getResultList(); // resultados com max 10

        users.forEach(user -> {
            System.out.printf("%s - %s => %s %n", user.getId(), user.getName(), user.getEmail());
        });

        em.close();
        emf.close();
    }
}
