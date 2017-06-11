package com.tickets.business.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tickets.business.entities.Cinema;
import com.tickets.business.entities.repositories.CinemaRepository;
import com.tickets.business.entities.Movie;
import com.tickets.business.services.*;;
@Service
public class CinemaService {
	@Autowired
    private CinemaRepository cinemaRepo; 
    @Autowired
    private MovieService movieService;
    public CinemaService() {
        super();
    }
    
    public void create(Cinema cinema) {
    	cinemaRepo.save(cinema);
    }

    public long cinemaCount(){
    	return  cinemaRepo.count();
    }
    public Cinema getCinema(Integer cinemaId) {
    	return cinemaRepo.findOne(cinemaId);
    }
    public Cinema getCinemaByName(String cinemaName) {
    	return cinemaRepo.findOneByCinemaName(cinemaName);
    }
    @SuppressWarnings("null")
	public List<Movie> getOnMovies(Cinema cinema) {
    	System.out.println("Entering Movieservice getOnCinemas");
    	List<Movie> onMovies = new ArrayList<Movie>();
   
    	Set<Movie> onMoviesSet = cinema.getCinemaMovies();
    	
    	if (onMoviesSet == null)System.out.println("onCinemas is null");
    	else System.out.println("onCinemasSet size:"+onMoviesSet.size());
    	Iterator<Movie> iter = onMoviesSet.iterator();
    	Movie t = null;
    	if (iter.hasNext()) {
    		t =iter.next();
    		if (t ==null) {
    			System.out.println("t is null");
    		} else {
    			onMovies.add(t);
    		}
    	} else {
        	System.out.println("dont have next");

    	}
		System.out.println("name:"+t.getMovieTitle()+" addr:"+t.getMovieBrief());
    	for (;iter.hasNext();) {
    		 t =iter.next();
    		onMovies.add(t);
    		System.out.println("name:"+t.getMovieTitle()+" addr:"+t.getMovieBrief());
    	}	
    	return onMovies;
    }

}
