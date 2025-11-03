package models.test.inh;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "logins")
public class Login extends People {
	@Column(length = 20, nullable = false)
	private String login;

	@Column(length = 20, nullable = false)
	private String password;
	
	public Login() {
		this(null, null, null);
	}

	public Login(String name, String login, String password) {
		super(name);
		this.login = login;
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
