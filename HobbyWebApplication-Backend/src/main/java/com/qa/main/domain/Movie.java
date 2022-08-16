package com.qa.main.domain;

import java.util.Objects;

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

	
	//Getters and Setters 
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	//HashCode and Equals methods
	
	@Override
	public int hashCode() {
		return Objects.hash(director, id, releaseYear, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(director, other.director) && id == other.id && releaseYear == other.releaseYear
				&& Objects.equals(title, other.title);
	}
}