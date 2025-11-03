package test.manytomany;

import infra.DAO;
import models.manytomany.Actor;
import models.manytomany.Movie;

public class TestManyToMany {
	public static void main(String[] args) {
//		Nephew nephewOne = new Nephew("Lucas");
//		Nephew nephewTwo = new Nephew("Heloisa");
//		
//		Uncle uncleOne = new Uncle("Márcio");
//		Uncle uncleTwo = new Uncle("Daniel");
//		
//		uncleOne.getNephews().add(nephewOne);
//		nephewOne.getUncles().add(uncleOne);
//		
//		uncleOne.getNephews().add(nephewTwo);
//		nephewTwo.getUncles().add(uncleOne);
//		
//		
//		uncleTwo.getNephews().add(nephewOne);
//		nephewOne.getUncles().add(uncleTwo);
//		
//		uncleTwo.getNephews().add(nephewTwo);
//		nephewTwo.getUncles().add(uncleTwo);
		
		DAO<Movie> dao = new DAO<>(Movie.class);

		Actor actorOne = new Actor("Tobias");
		Actor actorTwo = new Actor("Irene");
		Movie movieTwo = new Movie("Idosos em apuros 3", 9.2);
		movieTwo.store(actorOne);
		movieTwo.store(actorTwo);

		// este é o lado dono do relacionamento
		dao.store(movieTwo);
	}
}
