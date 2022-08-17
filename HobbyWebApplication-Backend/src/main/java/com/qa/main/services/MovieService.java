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
	
	public List<Movie> getByTitle(String title) {
		return repo.findMovieByTitle(title);
	}
	
	public List<Movie> getByYear(int year) {
		return repo.findMovieByReleaseYear(year);
	}
	
	public List<Movie> getByDirector(String director) {
		return repo.findMovieByDirector(director);
	}
	
	public Movie update(long id, Movie movie) {
		Movie existing = repo.findById(id).get();
		existing.setTitle(movie.getTitle());
		existing.setReleaseYear(movie.getReleaseYear());
		existing.setDirector(movie.getDirector());
		
		return repo.saveAndFlush(existing);
	}
	
	public boolean delete(long id) {
		repo.deleteById(id);
		return !repo.existsById(id);
	}

}