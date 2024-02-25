package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.rest.Movie;
import com.example.demo.service.MovieService;

import reactor.core.publisher.Mono;

@Controller
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	/**
	 * Display the search screen
	 * @param model
	 * @return search.html
	 */
	@GetMapping(value="/search")
	public String displaySearch(Model model) {
		return "search";
	}
	
	/**
	 * Receive user input from search.html, call getMovies from MovieService, and show search results.
	 * @param keyword Th user input entered in search.html
	 * @param model
	 * @return 
	 */
	@PostMapping(value="/search")
	public String SearchMovieByKeyword(@RequestParam("keyword") String keyword, Model model) {
		
		Mono<List<Movie>> moviesMono = movieService.getMovies(keyword);
        List<Movie> movies = moviesMono.block();
        model.addAttribute("movies", movies);
        return "search-result";
	}

}
