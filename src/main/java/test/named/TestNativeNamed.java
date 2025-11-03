package test.named;

import infra.DAO;
import models.PointMovie;

public class TestNativeNamed {
	public static void main(String[] args) {
		DAO<PointMovie> dao = new DAO<>(PointMovie.class);
		
		PointMovie pointMovie = dao.findOne("getMoviesAverage");
	
		System.out.println(pointMovie.getAverage());
	}
}
