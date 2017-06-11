package com.tickets.business.entities.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.tickets.business.entities.Cinema;
import com.tickets.business.entities.Movie;


@Repository
public interface CinemaRepository extends CrudRepository<Cinema, Integer> {
	Cinema findOneByCinemaName(String cinemaName);
}
