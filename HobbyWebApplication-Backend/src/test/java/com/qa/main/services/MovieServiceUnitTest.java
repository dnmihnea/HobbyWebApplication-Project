package com.qa.main.services;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.main.domain.Movie;
import com.qa.main.repos.MovieRepo;

@SpringBootTest
public class MovieServiceUnitTest {

	@Autowired
	private MovieService service;
	
	@MockBean
	private MovieRepo repo;
	
	@Test
	public void createTest() {

		Movie entry = new Movie("XYZ", 2001, "ZYX");
		Movie result = new Movie(2L, "XYZ", 2001, "ZYX");
		
		Mockito.when(repo.saveAndFlush(entry)).thenReturn(result);
		assertEquals(result, service.create(entry));
	}
	
	@Test
	public void getAllTest() {
		
		List<Movie> result = new ArrayList<>();
		result.add(new Movie(1L, "ABC", 2000, "CBA"));
		
		Mockito.when(repo.findAll()).thenReturn(result);
		assertEquals(result, service.getAll());
	}
	
	@Test
	public void getByIdTest() {
		
		Movie result = new Movie(1L, "ABC", 2000, "CBA");
		
		Mockito.when(repo.findById(1L)).thenReturn(Optional.of(result));
		assertEquals(result, service.getById(1L));
	}
	
	@Test
	public void getByTitleTest() {
		
		List<Movie> result = new ArrayList<>();
		result.add(new Movie(1L, "ABC", 2000, "CBA"));
		
		Mockito.when(repo.findMovieByTitle("ABC")).thenReturn(result);
		assertEquals(result, service.getByTitle("ABC"));
	}
	
	@Test
	public void getByYearTest() {
		
		List<Movie> result = new ArrayList<>();
		result.add(new Movie(1L, "ABC", 2000, "CBA"));
		
		Mockito.when(repo.findMovieByReleaseYear(2000)).thenReturn(result);
		assertEquals(result, service.getByYear(2000));
	}
	
	@Test
	public void getByDirectorTest() {
		
		List<Movie> result = new ArrayList<>();
		result.add(new Movie(1L, "ABC", 2000, "CBA"));
		
		Mockito.when(repo.findMovieByDirector("CBA")).thenReturn(result);
		assertEquals(result, service.getByDirector("CBA"));
	}
	
	@Test
	public void updateTest() {
		
		Movie result = new Movie(1L, "ABC", 2000, "CBA");
		Mockito.when(repo.findById(1L)).thenReturn(Optional.of(result));
		Movie existing = repo.findById(1L).get();
		Mockito.when(repo.saveAndFlush(existing)).thenReturn(result);
		
		assertEquals(result, service.update(1L, existing));
	}
	
	@Test
	public void deleteTest() {
		
		Mockito.when(repo.existsById(1L)).thenReturn(false);
		assertEquals(true, service.delete(1L));
	}
}