package com.tickets.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tickets.business.entities.User;
import com.tickets.business.services.UserService;
import com.tickets.business.entities.*;
import com.tickets.business.services.*;


@Controller
public class MainController {

    @Autowired
    private UserService userService;
    @Autowired
    private MovieService movieService;
    
    public MainController() {
        super();
    }

  
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }
    @RequestMapping(path = "/getter", method = RequestMethod.POST)
    public String getter(final User user, final Model model) {
    	
            model.addAttribute("msg", "user number is "+userService.UserCount()+"names are"
            		+ userService.viewusername()
         );
    	
       
        return "response";
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String register(final User user, final Model model) {
    	if (userService.hasUsername(user.getUsername())) {
            model.addAttribute("msg", "Register failed. Username exists.");
    	} else {
            userService.create(user);
            model.addAttribute("msg", "Register " + user.toString() + " succeed.");
    	}
        return "response";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(final User user, final Model model) {
    	if (!userService.hasUsername(user.getUsername())) {
            model.addAttribute("msg", "Login failed. Username doesn't exist.");
    	} else if (userService.permitLogin(user.getUsername(), user.getPassword())) {
            model.addAttribute("msg", "Login " + user.toString() + " succeed.");
    	} else {
    		model.addAttribute("msg", "Login failed. Incorrect password.");
    	}
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
    @RequestMapping(path = "/addmovie", method = RequestMethod.POST)
    public String addMovie(final Movie movie, final Model model) {

    	movieService.create(movie);
    	model.addAttribute("msg", "Movie id:"+movie.getMovieId().toString()+
    			"movie title"+movie.getMovieTitle().toString()+
    			"movie brief"+movie.getMovieBrief().toString()
    			);
        return "response";
    }
}
