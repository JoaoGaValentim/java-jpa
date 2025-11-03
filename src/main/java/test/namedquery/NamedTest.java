package test.namedquery;

import java.util.List;

import infra.DAO;
import models.manytomany.Actor;
import models.manytomany.Movie;

public class NamedTest {

	public static void main(String[] args) {
		DAO<Movie> movieDao = new DAO<Movie>(Movie.class);
		List<Movie> movies = movieDao.search("getMoviesPointsBiggerThan", "points", 8.0);

		for (Movie movie : movies) {
			System.out.println(movie.getName());
			
			for (Actor actor : movie.getActors()) {
				System.out.println(actor.getName());
			}
		}
	}

}
