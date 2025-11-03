package test.basic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import models.basic.User;

public class NewUserTest {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("java-jpa");
		EntityManager em = emf.createEntityManager();
		String jpql = "SELECT u FROM users u WHERE u.email = :email";

		TypedQuery<User> query = em.createQuery(jpql, User.class);

		User user = new User("X", "x@gmail.com");
		query.setParameter("email", user.getEmail());

		List<User> existingUsers = query.getResultList();

		if (!existingUsers.isEmpty()) {
			System.out.println("Esse email já consta no sistema :/");
			return;
		}

		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();

		em.close();
		emf.close();
		System.out.println("id gereado => " + user.getId());
		System.out.println("Usuário cadastrado no sistema!");
	}
}
