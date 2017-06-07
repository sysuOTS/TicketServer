package com.tickets.business.entities;
import java.io.Serializable;

import javax.persistence.*;
@Entity
@Table(name = "Movie")
public class Movie {
	private Integer movieId;
	private String movieTitle;
	private String movieBrief;
	public Movie(){
		super();
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movie_id")
    public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer id){
		movieId = id;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String title){
		movieTitle = title;
	}
	public String getMovieBrief() {
		return movieBrief;
	}
	public void setMovieBrief(String brief){
		movieBrief = brief;
	}
}
