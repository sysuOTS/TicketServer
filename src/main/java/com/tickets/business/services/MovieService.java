package com.tickets.business.services;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tickets.business.entities.Movie;
import com.tickets.business.entities.Cinema;
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
    	Movie m = null;
    	m = movieRepo.findByMovieTitle(title).get(0);
    	return m;
    }
    public boolean hasMovie(String title) {
    	if (movieRepo.findByMovieTitle(title)!=null) return true;
    	else return false;
    }
    @SuppressWarnings("null")
	public List<Cinema> getOnCinemas(Movie movie) {
    	System.out.println("Entering Movieservice getOnCinemas");
    	List<Cinema> onCinemas = null;
    	Set<Cinema> onCinemasSet = movie.getOnCinemas();
    	if (onCinemasSet == null)System.out.println("onCinemas is null");
    	else System.out.println("onCinemasSet size:"+onCinemasSet.size());
    	for (Iterator<Cinema> iter = onCinemasSet.iterator();iter.hasNext();) {
    		Cinema t =iter.next();
    		onCinemas.add(t);
    		System.out.println("name:"+t.getCinemaName()+" addr:"+t.getCinemaAddr());
    	}	
    	return onCinemas;
    }	
}
