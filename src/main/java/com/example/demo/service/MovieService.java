package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.rest.Movie;
import com.example.demo.rest.MovieResponse;

import reactor.core.publisher.Mono;

@Service
public class MovieService {
	
	@Autowired
	WebClient.Builder builder;
	
	// Get API key from application.properties
	@Value("${api.key}")
    private String apiKey;
	
	public Mono<List<Movie>> getMovieList(String keyword){
		String url = "https://api.themoviedb.org/3/search/movie?api_key=" + apiKey + "&query=" + keyword;
		return builder.build()
                .get()
                .uri(url) 
                .retrieve()
                .bodyToMono(MovieResponse.class) 
                .flatMapIterable(MovieResponse::getResults)
                .collectList();
	}
	
	public Mono<List<Movie>> getTrendingMoviesOfDay(){
		String url = "https://api.themoviedb.org/3/trending/movie/day?api_key=" + apiKey + "&language=en-US";
		return builder.build()
                .get()
                .uri(url) 
                .retrieve()
                .bodyToMono(MovieResponse.class) 
                .flatMapIterable(MovieResponse::getResults)
                .collectList();
	}

}
