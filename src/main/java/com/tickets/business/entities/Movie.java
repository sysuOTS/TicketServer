package com.tickets.business.entities;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "movie")
public class Movie {
	

	private Integer movieId;
	
	
	private String movieTitle;
	

	private String movieBrief;

    private Set<Cinema> OnCinemas = new HashSet<Cinema>();
    
	private Date movieOnshowdate;
	
	private String moviePostpath;
    
	@Override
    public String toString() {
        return "Movie [id=" + movieId + ", title=" + movieTitle + ", brief=" + movieBrief +
        		", on show date= not sure"+"]";
    }
	
	public Movie() {
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY	)
    @Column(name = "movie_id")
    public Integer getMovieId() {
		return this.movieId;
	}

	@Column(name = "movie_title")
	public String getMovieTitle() {
		return this.movieTitle;
	}
	@Column(name = "movie_brief")
	public String getMovieBrief() {
		return this.movieBrief;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	@Column(name = "movie_onshowdate")
	public Date getMovieOnshowdate() {
		return this.movieOnshowdate;
	}
	
	@Column(name = "movie_postpath")
	public String getMoviePostpath() {
		return this.moviePostpath;
	}
	
//	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "cinemaMovies")
	@ManyToMany(targetEntity = Cinema.class, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "R_Cinema_CinemaMovies", 
            joinColumns = {@JoinColumn(name = "movie_id", referencedColumnName = "", foreignKey=@ForeignKey(name="FK_R_movie_cinema"))},
            inverseJoinColumns = {@JoinColumn(name = "cinema_id", referencedColumnName ="cinema_id", foreignKey=@ForeignKey(name="FK_R_cinema_movie"))})
    
	public Set<Cinema> getOnCinemas(){
		return this.OnCinemas;
	}
	
	
	public void setMovieId(Integer id){
		this.movieId = id;
	}

	public void setMovieTitle(String title){
		this.movieTitle = title;
	}

	public void setMovieBrief(String brief){
		this.movieBrief = brief;
	}
	
	public void setMovieOnshowdate(Date date){
		this.movieOnshowdate = date;
	}
	public void setOnCinemas(Set<Cinema> oncinemas) {
		this.OnCinemas = oncinemas;
	}
	public void setMoviePostpath(String path) {
		this.moviePostpath = path;
	}
}
