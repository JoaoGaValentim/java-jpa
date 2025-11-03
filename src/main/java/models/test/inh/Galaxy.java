package models.test.inh;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "galaxies")
public class Galaxy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "universe_id", referencedColumnName = "id")
	private Universe universe;
	
	@OneToMany(mappedBy = "galaxy", cascade = CascadeType.PERSIST)
	private List<CelestialBody> celestialBodies = new ArrayList<>();
	
	public Galaxy() {
	}

	public Galaxy(String name) {
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

	public Universe getUniverse() {
		return universe;
	}

	public void setUniverse(Universe universe) {
		this.universe = universe;
	}

	public List<CelestialBody> getCelestialBodies() {
		return celestialBodies;
	}

	public void setCelestialBodies(List<CelestialBody> celestialBodies) {
		this.celestialBodies = celestialBodies;
	}
	
	public void addCelestialBodie(CelestialBody celestialBody) {
		if (celestialBody.getGalaxy() == null && !getCelestialBodies().contains(celestialBody)) {
			getCelestialBodies().add(celestialBody);
			celestialBody.setGalaxy(this);
		}
	}
}
