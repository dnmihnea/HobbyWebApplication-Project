package com.qa.main.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {
	
	//Columns
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private int releaseYear;
	
	@Column(nullable = false)
	private String director;
	
	//Constructors
	
	public Movie() {}
	
	public Movie(String title, int releaseYear, String director) {
		super();
		this.title = title;
		this.releaseYear = releaseYear;
		this.director = director;
	}
	
	public Movie(long id, String title, int releaseYear, String director) {
		super();
		this.id = id;
		this.title = title;
		this.releaseYear = releaseYear;
		this.director = director;
	}
	
	

}
