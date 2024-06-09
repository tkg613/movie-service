package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.rest.Movie;
import com.example.demo.service.MovieService;

import reactor.core.publisher.Mono;

@Controller
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping(value="/")
	public String index(Model model) {
		Mono<List<Movie>> moviesMono = movieService.getTrendingMoviesOfDay();
        List<Movie> movies = moviesMono.block();
        
        model.addAttribute("movies", movies);
		return "index";
	}
	
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
	 * Receive user input from search.html, and send GET request to display the search results.
	 * @param keyword The user input entered in search.html.
	 * @param model
	 * @return 
	 */
	@PostMapping(value="/search")
	public String SubmitSearchKeyword(@RequestParam("keyword") String keyword, Model model) {
		return "redirect:/search/" + keyword;
	}
	
	/**
	 * Call getMovies from movieService based on the search criteria and pass the result and keyword to the result view.
	 * @param keyword The user input entered in search.html.
	 * @param model
	 * @return
	 */
	@GetMapping(value="/search/{keyword}")
	public String DisplaySearchResults(@PathVariable("keyword") String keyword, Model model) {
		
		Mono<List<Movie>> moviesMono = movieService.getMovieList(keyword);
        List<Movie> movies = moviesMono.block();
        
        model.addAttribute("movies", movies);
        model.addAttribute("keyword", keyword);
        return "search-result";
	}

}
