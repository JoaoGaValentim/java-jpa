package models.test.inh;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "planets")
public class Planet extends CelestialBody {
	private Double sunDistance;
	
	public Planet() {
	}

	public Planet(String name, Double size, Double sunDistance) {
		super(name, size);
		this.sunDistance = sunDistance;
	}

	public Double getSunDistance() {
		return sunDistance;
	}

	public void setSunDistance(Double sunDistance) {
		this.sunDistance = sunDistance;
	}
}
