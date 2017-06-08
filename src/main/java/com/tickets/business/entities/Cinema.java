package com.tickets.business.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "Cinema")
public class Cinema {
	  	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "cinema_id")
	    private Integer cinemaId;
	    
	    @Column(name = "cinema_name",nullable = false,length = 30)
	    private String cinemaName;
	    
	    @Column(name = "cinema_addr",nullable = false,length = 50)
	    private String cinemaAddr;
	    
	    
	    public Cinema() {
	        super();
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
	    public Integer getCinemaId(){
	    	return this.cinemaId;
	    }
	    public String getCinemaName(){
	    	return this.cinemaName;
	    }
	    public String getCinemaAddr(){
	    	return this.cinemaAddr;
	    }
	    
		
}
