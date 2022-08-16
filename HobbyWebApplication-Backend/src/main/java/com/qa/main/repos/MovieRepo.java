package com.qa.main.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.main.domain.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long> {

}
