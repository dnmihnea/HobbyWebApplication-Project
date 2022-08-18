package com.qa.main.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Objects;

import org.junit.jupiter.api.Test;

public class MovieUnitTest {
			
		private final Movie m = new Movie(1L, "ABC", 2000, "CBA");
		
		@Test
		public void constructorTest() {
			Movie one = new Movie(1L, "DEF", 2020, "FED");
			Movie two = new Movie("DEF", 2020, "FED");
			Movie three = new Movie();
			assertTrue(one instanceof Movie);
			assertTrue(two instanceof Movie);
			assertTrue(three instanceof Movie);
		}
		
		@Test
		public void setIdTest() {
			Long id = 10L;
			m.setId(id);
			assertEquals(id, m.getId(), 10L);
		}
		
		@Test
		public void setTitleTest() {
			String title = "XYZ";
			m.setTitle(title);
			assertEquals(title, m.getTitle());
		}
		
		@Test
		public void setReleaseYearTest() {
			int year = 2001;
			m.setReleaseYear(year);
			assertEquals(year, m.getReleaseYear());
		}
		
		@Test
		public void setDirectorTest() {
			String director = "ZYX";
			m.setDirector(director);
			assertEquals(director, m.getDirector());
		}
		
		@Test
		public void hashCodeTest() {
			int hash = Objects.hash(1L, "ABC", 2000, "CBA");
			assertEquals(hash, m.hashCode());
		}
		
		@Test
		public void equalsTest() {
			Movie copy = new Movie(1L, "ABC", 2000, "CBA");
			assertEquals(true, m.equals(copy));
		}
}
