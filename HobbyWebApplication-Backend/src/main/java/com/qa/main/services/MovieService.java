package com.qa.main.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.main.domain.Movie;
import com.qa.main.exceptions.MovieNotFoundException;
import com.qa.main.repos.MovieRepo;

@Service
public class MovieService {
	
	private MovieRepo repo;
	
	public MovieService(MovieRepo repo) {
		this.repo = repo;
	}
	
	public Movie create(Movie movie) {
		return repo.saveAndFlush(movie);
	}
	
	public List<Movie> getAll() {
		return repo.findAll();
	}
	
	public Movie getById(long id) {
		return repo.findById(id).orElseThrow(MovieNotFoundException::new);
	}

}
