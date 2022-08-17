package com.qa.main.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.main.domain.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long> {
	
	List<Movie> findMovieByTitle(String title);
	
	@Query(value = "SELECT * FROM movie WHERE release_year = ?1", nativeQuery = true)
	List<Movie> findMovieByReleaseYear(int releaseYear);
	
	List<Movie> findMovieByDirector(String director);

}