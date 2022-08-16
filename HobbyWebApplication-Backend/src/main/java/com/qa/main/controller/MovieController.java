package com.qa.main.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.main.services.MovieService;

@RestController
@CrossOrigin
@RequestMapping("/movie")
public class MovieController {
	private MovieService service;

	

}
