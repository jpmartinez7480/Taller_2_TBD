package cl.citiaps.spring.backend.entities;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Entity
@Table(name="film")
@NamedQuery(name="Film.findAll",query="SELECT f from Film f")

public class Film implements Serializable{
	private static final long serialVersionUID = 1L;

	@ManyToMany(mappedBy = "filmsActor")
	private List<Actor> actorFilms;

	@Id
	@Column(name = "film_id",unique = true,nullable=false)
	private int filmId;

	@Column(name = "title", nullable = false, length=45)
	private String filmTitle;

	@Column(name = "description",nullable=false, length=100)
	private String filmDescription;

	@Column(name = "release_year",nullable=false,unique = false)
	private int filmReleaseYear;

	public Film(){}

	public List<Actor> getactorsFilm(){
		return this.actorFilms;
	}  

	public int getFilmId(){
		return this.filmId;
	}

	public String getFilmTitle(){
		return this.filmTitle;
	}

	public String getFilmDescription(){
		return this.filmDescription;
	}

	public int getFilmReleaseYear(){
		return this.filmReleaseYear;
	}

	
}




