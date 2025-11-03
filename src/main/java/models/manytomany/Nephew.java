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
@Table(name = "nephews")
public class Nephew {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 255)
	private String name;

	@ManyToMany(mappedBy = "nephews")
	private List<Uncle> uncles = new ArrayList<>();

	public Nephew() {
	}

	public Nephew(String name) {
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

	public List<Uncle> getUncles() {
		return uncles;
	}

	public void setUncles(List<Uncle> uncles) {
		this.uncles = uncles;
	}
}
