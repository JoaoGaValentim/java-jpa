package models.test.inh;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Table(name = "students")
@Inheritance(strategy = InheritanceType.JOINED)
public class Student {
	@Id
	private long ra;
	
	private String name;

	public Student() {
	}
	
	public Student(long ra, String name) {
		super();
		this.ra = ra;
		this.name = name;
	}

	public long getRa() {
		return ra;
	}

	public void setRa(long ra) {
		this.ra = ra;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
