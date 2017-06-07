package com.tickets.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tickets.business.entities.Cinema;
import com.tickets.business.entities.repositories.CinemaRepository;

@Service
public class CinemaService {
	@Autowired
    private CinemaRepository cinemaRepo; 
    
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

}
