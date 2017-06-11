package com.tickets.web.controller;

import java.sql.Date;

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
public class SearchController {

    @Autowired
    private UserService userService;
    @Autowired
    private MovieService movieService;
    @Autowired
    private CinemaService cinemaService;
    
    public SearchController() {
        super();
    }

  
    @RequestMapping(path = "/searchMovie", method = RequestMethod.GET)
    public String get() {
    	return "search";

    }
    @RequestMapping(path = "/searchMovie", method = RequestMethod.POST)
    public String searchMovie(final Movie movie, final Model model) {
    	Movie find = movieService.getMoviebyTitle(movie.getMovieTitle());
    	if( find != null) {
			model.addAttribute("msg", find.toString());
			model.addAttribute("moviepostpath", find.getMoviePostpath());
			model.addAttribute("onCinemas",movieService.getOnCinemas(find));
		}  
        return "movie_response";
    }
    @RequestMapping(path = "/searchCinema", method = RequestMethod.POST)
    public String searchCinema(@RequestParam String cinemaName, final Model model) {
    	Cinema find = cinemaService.getCinemaByName(cinemaName);
    	if( find != null) {
			model.addAttribute("msg", "name:"+find.getCinemaName()+" addr:"+find.getCinemaAddr());
			model.addAttribute("onMovies",cinemaService.getOnMovies(find));
		}  
        return "cinema_response";
    }
}
