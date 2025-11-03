package models.test.inh;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "special_students")
public class SpecialStudent extends Student {
	private String type;

	public SpecialStudent() {
	}

	public SpecialStudent(long ra, String name, String type) {
		super(ra, name);
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
