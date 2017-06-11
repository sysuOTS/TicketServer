package com.tickets.business.entities;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
import com.tickets.business.services.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;


import com.tickets.business.entities.*;
import com.tickets.business.entities.repositories.CinemaRepository;
import com.tickets.business.entities.repositories.MovieRepository;
@Entity
@Table(name = "Cinema")
public class Cinema implements Serializable {

	    private Integer cinemaId;
	    
	   
	    private String cinemaName;
	    
	
	    private String cinemaAddr;
	    

	    private Set<Movie> cinemaMovies = new HashSet<Movie>();
	    
	   
	    public Cinema() {
	        super();
	    }
	    
	    public Cinema(String name,String addr,String movies) {
	    	setCinemaName(name);
	    	setCinemaAddr(addr);
	    	
	    }
	   
	    public void setCinemaId(Integer id){
	    	this.cinemaId = id;
	    }
	    public void setCinemaName(String name){
	    	this.cinemaName = name;
	    }
	    public void setCinemaAddr(String addr){
	    	this.cinemaAddr = addr;
	    }
	
	    public void setCinemaMovies(Set<Movie> movies) {
	    	this.cinemaMovies = movies;
	    }
	  
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "cinema_id")
	    public Integer getCinemaId(){
	    	return this.cinemaId;
	    }
	    @Column(name = "cinema_name",nullable = false,length = 30)
	    public String getCinemaName(){
	    	return this.cinemaName;
	    }
	    @Column(name = "cinema_addr",nullable = false,length = 50)
	    public String getCinemaAddr(){
	    	return this.cinemaAddr;
	    }
	    
	    @ManyToMany(targetEntity = Movie.class, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	    @JoinTable(name = "R_Cinema_CinemaMovies",
	            joinColumns = {@JoinColumn(name = "cinema_id", referencedColumnName = "cinema_id", foreignKey=@ForeignKey(name="FK_R_cinema_movie"))},
	            inverseJoinColumns = {@JoinColumn(name = "movie_id", referencedColumnName ="movie_id", foreignKey=@ForeignKey(name="FK_R_movie_cinema"))})
	    public Set<Movie> getCinemaMovies(){
	    	return this.cinemaMovies;
	    }
	    
		
}
