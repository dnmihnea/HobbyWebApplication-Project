package com.qa.main.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.main.domain.Movie;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:testschema.sql", "classpath:testdata.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class MovieControllerIntegrationTest {
	
	@Autowired 
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	public void createTest() throws Exception {
		
		Movie entry = new Movie("XYZ", 2001, "ZYX");
		String entryAsJSON = mapper.writeValueAsString(entry);
		
		Movie result = new Movie(2L, "XYZ", 2001, "ZYX");
		String resultAsJSON = mapper.writeValueAsString(result);
		
		mvc.perform(post("/movie/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entryAsJSON))
				.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void getAllTest() throws Exception {
		
		List<Movie> result = new ArrayList<>();
		result.add(new Movie(1L, "ABC", 2000, "CBA"));
		String resultAsJSON = mapper.writeValueAsString(result);
		
		mvc.perform(get("/movie/getAll")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void getByIdTest() throws Exception{
		Movie result = new Movie(1L, "ABC", 2000, "CBA");
		String resultAsJSON = mapper.writeValueAsString(result);
		
		mvc.perform(get("/movie/getById/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void getByTitleTest() throws Exception{
		List<Movie> result = new ArrayList<>();
		result.add(new Movie(1L, "ABC", 2000, "CBA"));
		
		String resultAsJSON = mapper.writeValueAsString(result);
		
		mvc.perform(get("/movie/getByTitle/ABC")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void getByYearTest() throws Exception{
		List<Movie> result = new ArrayList<>();
		result.add(new Movie(1L, "ABC", 2000, "CBA"));
		String resultAsJSON = mapper.writeValueAsString(result);
		
		mvc.perform(get("/movie/getByYear/2000")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void getByDirectorTest() throws Exception{
		List<Movie> result = new ArrayList<>();
		result.add(new Movie(1L, "ABC", 2000, "CBA"));
		
		String resultAsJSON = mapper.writeValueAsString(result);
		
		mvc.perform(get("/movie/getByDirector/CBA")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void updateTest() throws Exception{
		
		Movie update = new Movie("DEF", 2020, "FED");
		String updateAsJSON = mapper.writeValueAsString(update);
		
		Movie result = new Movie(1L, "DEF", 2020, "FED");
		String resultAsJSON = mapper.writeValueAsString(result);
		
		mvc.perform(put("/movie/update/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(updateAsJSON))
				.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void deleteTest() throws Exception{
		mvc.perform(delete("/movie/delete/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());
	}
}
