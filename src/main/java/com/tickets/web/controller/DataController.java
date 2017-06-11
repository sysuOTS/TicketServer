package com.tickets.web.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tickets.business.entities.*;
import com.tickets.business.services.*;


@Controller
public class DataController {

    @Autowired
    private UserService userService;
    @Autowired
    private MovieService movieService;
    @Autowired
    private CinemaService cinemaService;
    
    public DataController() {
        super();
    }

  
    @RequestMapping(path = "/adddata", method = RequestMethod.GET)
    public String adddata() {
        return "add_data";
    }
    @RequestMapping(path = "/getter", method = RequestMethod.POST)
    public String getter(final User user, final Model model) {
    	
            model.addAttribute("msg", "user number is "+userService.UserCount()+"names are"
            		+ userService.viewusername()
         );
    	
       
        return "response";
    }
    
    @RequestMapping(path = "/getmovie", method = RequestMethod.POST)
    public String getmovie(final Movie movie, final Model model) {

    	if(movieService.getMovie(movie.getMovieId()) != null) {
			model.addAttribute("msg", movieService.getMovie(movie.getMovieId()).toString()+
					"\n type2:"+
					movie.toString());
		}  
        return "response";
    }
    @RequestMapping(path = "/DateTest", method = RequestMethod.POST)
    public String addMovie(@RequestParam Date date,
    		final Model model) {
    	System.out.println("the date is :"+ date.toString());
        return "response";
    }
    
    @RequestMapping(path = "/addmovie", method = RequestMethod.POST)
    public String addMovie(@RequestParam String movieTitle,
    		@RequestParam String movieBrief,
    		@RequestParam String moviePostpath,
    		@RequestParam Date movieOnshowdate,
    		@RequestParam String movieOnshowCinemas,
    		final Model model) {
    	Movie movie = new Movie();
    	System.out.println("the date is :"+ movieOnshowdate.toString());
    	movie.setMovieId(null);
    	movie.setMovieTitle(movieTitle);
    	movie.setMovieBrief(movieBrief);
    	movie.setMovieOnshowdate(movieOnshowdate);
    	Set<Cinema> cinemas = new HashSet<Cinema>();
    	String regex = ":";
    	String[] CinemasName = movieOnshowCinemas.split(regex);
    	for (String CinemaName:CinemasName) {
    		Cinema c = null;
    		c = cinemaService.getCinemaByName(CinemaName);
    		
    		if (c == null) {
    			System.out.println("Not find Cinema Named:"+CinemaName);
    		} else {
    			c.setCinemaId(null);
    			cinemas.add(c);
    		}
    	}
    	System.out.println("set cinemas number :"+ movie.getOnCinemas().size());
    	
    	movieService.create(movie);
    	System.out.println("after save:"+ movieService.getMoviebyTitle(movie.getMovieTitle()).getOnCinemas().size());
    	
    	System.out.println("the movieondate is :"+ movie.getMovieOnshowdate().toString());
    	model.addAttribute("msg", "Movie id:"+movie.getMovieId().toString()+
    			"movie title"+movie.getMovieTitle().toString()+
    			"movie brief"+movie.getMovieBrief().toString()
    			);
        return "response";
    }
    
    @RequestMapping(path = "/addcinema", method = RequestMethod.POST)
   public String addMovie(@RequestParam String cinemaName,
    		@RequestParam String cinemaAddr,
    		@RequestParam String cinemaMovies,
    		final Model model) {
    	Cinema cinema = null;
    	cinema = new Cinema(cinemaName,cinemaAddr,cinemaMovies);
    	Set<Movie> movies = new HashSet<Movie>();
    	String regex = ":";
    	String[] titles = cinemaMovies.split(regex);
    	for (String title : titles) {
    		System.out.println("movie title is:"+title);
    		Movie m = null;
    		m = movieService.getMoviebyTitle(title);
    		m.setMovieId(null);
    		if (m == null) {
    			System.out.println("movie not find");
    		} else {
    			movies.add(m);
    		}
    	
		}
    	cinema.setCinemaMovies(movies);
    	cinemaService.create(cinema);
    	model.addAttribute("msg", "cinema name:"+cinema.getCinemaName().toString()+
    			"cinema addr"+cinema.getCinemaName().toString()
    			);
        return "response";
    }
    

}
