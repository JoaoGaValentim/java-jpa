package test.inh;

import infra.DAO;
import models.test.inh.Login;

public class AddUserTest {
	public static void main(String[] args) {
		DAO<Login> dao = new DAO<>(Login.class);
		
		Login user = new Login("João", "joao@gmail.com", "123456");
		
		dao.store(user);
	}
}
