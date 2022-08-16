package com.qa.main.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.main.domain.Movie;
import com.qa.main.services.MovieService;

@RestController
@CrossOrigin
@RequestMapping("/movie")
public class MovieController {
	
	private MovieService service;
	
	public MovieController(MovieService service) {
		this.service = service;
	}

	//Post Request
	
	@PostMapping("/create")
	public ResponseEntity<Movie> create(@RequestBody Movie movie) {
		return new ResponseEntity<Movie>(service.create(movie, HttpStatus.CREATED));
	}

}
