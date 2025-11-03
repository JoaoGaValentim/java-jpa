package models.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	private Double points;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
	    name = "actor_movies",
	    joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
	    inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "id")
	)
	private List<Actor> actors = new ArrayList<>();
	
	public Movie() {
	}
	
	public Movie(String name, Double points) {
		super();
		this.name = name;
		this.points = points;
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

	public Double getPoints() {
		return points;
	}

	public void setPoints(Double points) {
		this.points = points;
	}

	public List<Actor> getActors() {
		return actors == null ? new ArrayList<>() : actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	
	public void store(Actor actor) {
		if (actor != null && !getActors().contains(actor)) {
			getActors().add(actor);
			if (!actor.getMovies().contains(this)) {
				actor.getMovies().add(this);
			}
		}
	}
}
