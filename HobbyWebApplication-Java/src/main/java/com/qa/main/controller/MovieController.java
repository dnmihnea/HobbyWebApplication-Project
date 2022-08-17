package com.qa.main.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		return new ResponseEntity<Movie>(service.create(movie), HttpStatus.CREATED);
	}
	
	//Get Requests
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Movie>> getAll() {
		return new ResponseEntity<List<Movie>>(service.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Movie> getById(@PathVariable long id) {
		return new ResponseEntity<Movie>(service.getById(id), HttpStatus.OK);
	}
	
	@GetMapping("/getByTitle/{title}")
	public ResponseEntity<List<Movie>> getByTitle(@PathVariable String title) {
		return new ResponseEntity<List<Movie>>(service.getByTitle(title), HttpStatus.OK);
	}
	
	@GetMapping("/getByYear/{year}")
	public ResponseEntity<List<Movie>> getByYear(@PathVariable int year) {
		return new ResponseEntity<List<Movie>>(service.getByYear(year), HttpStatus.OK);
	}
	
	@GetMapping("/getByDirector/{director}")
	public ResponseEntity<List<Movie>> getByDirector(@PathVariable String director) {
		return new ResponseEntity<List<Movie>>(service.getByDirector(director), HttpStatus.OK);
	}
	
	//Put Request
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Movie> update(@PathVariable long id, @RequestBody Movie movie) {
		return new ResponseEntity<Movie>(service.update(id, movie), HttpStatus.OK);
	}
	
	//Delete Request
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable long id) {
		return new ResponseEntity<Boolean>(service.delete(id), HttpStatus.NO_CONTENT);
	}

}