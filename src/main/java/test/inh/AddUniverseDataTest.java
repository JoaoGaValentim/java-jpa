package test.inh;


import infra.DAO;
import models.test.inh.CelestialBody;
import models.test.inh.Galaxy;
import models.test.inh.Planet;
import models.test.inh.Universe;

public class AddUniverseDataTest {
	public static void main(String[] args) {
		DAO<Object> dao = new DAO<>();
	
		Universe universe = new Universe("C-137");
		
		Galaxy galaxyOne = new Galaxy("Andromeda");
		CelestialBody celestialBody = new Planet("Gazorp", 10000.0, 120000000.0);
		
		galaxyOne.addCelestialBodie(celestialBody);
		universe.addGalaxy(galaxyOne);
	
		
		dao.store(universe);
	}
}
