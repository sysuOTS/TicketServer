package com.tickets.business.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movie_id")
	private Integer movieId;
	
	@Column(name = "movie_title")
	private String movieTitle;
	
	@Column(name = "movie_brief")
	private String movieBrief;
    
	@Override
    public String toString() {
        return "Movie [id=" + movieId + ", title=" + movieTitle + ", brief=" + movieBrief + "]";
    }
	
	public Movie(){
		super();
	}

    public Integer getMovieId() {
		return this.movieId;
	}
	public void setMovieId(Integer id){
		this.movieId = id;
	}
	
	public String getMovieTitle() {
		return this.movieTitle;
	}
	public void setMovieTitle(String title){
		this.movieTitle = title;
	}

	public String getMovieBrief() {
		return this.movieBrief;
	}
	public void setMovieBrief(String brief){
		this.movieBrief = brief;
	}
}
