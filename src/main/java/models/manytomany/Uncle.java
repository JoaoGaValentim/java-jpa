package models.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "uncles")
public class Uncle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 255)
	private String name;
	
	@ManyToMany
	private List<Nephew> nephews = new ArrayList<>();  
	
	public Uncle() {
	}

	public Uncle(String name) {
		super();
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Nephew> getNephews() {
		return nephews;
	}

	public void setNephews(List<Nephew> nephews) {
		this.nephews = nephews;
	}
}
