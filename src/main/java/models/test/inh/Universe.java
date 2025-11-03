package models.test.inh;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "universes")
public class Universe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	@OneToMany(mappedBy = "universe", cascade = CascadeType.PERSIST)
	private List<Galaxy> galaxies = new ArrayList<Galaxy>();
	
	public Universe() {
	}
	
	public Universe(String name) {
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

	public List<Galaxy> getGalaxies() {
		return galaxies;
	}

	public void setGalaxies(List<Galaxy> galaxies) {
		this.galaxies = galaxies;
	}
	
	public void addGalaxy(Galaxy galaxy) {
		if (galaxy.getUniverse() == null && !getGalaxies().contains(galaxy)) {
			getGalaxies().add(galaxy);
			galaxy.setUniverse(this);
		}
	}
}
