package com.tickets.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tickets.business.entities.Movie;
import com.tickets.business.entities.repositories.MovieRepository;

@Service
public class MovieService {
	@Autowired
    private MovieRepository movieRepo; 
    
    public MovieService() {
        super();
    }
    
    public void create(Movie movie) {
    	movieRepo.save(movie);
    }

    public long MovieCount(){
    	return  movieRepo.count();
    }
    public Movie getMovie(Integer movieId) {
    	return movieRepo.findOne(movieId);
    }
    public Movie getMoviebyTitle(String title) {
    	return movieRepo.findByMovieTitle(title).get(0);
    }

}
