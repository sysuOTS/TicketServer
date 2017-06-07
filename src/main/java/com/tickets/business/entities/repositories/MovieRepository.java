package com.tickets.business.entities.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.tickets.business.entities.Movie;


@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {
	List<Movie> findByMovieTitle(String movieTitle);
}
