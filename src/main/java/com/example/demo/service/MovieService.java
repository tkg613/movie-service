package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.rest.Movie;
import com.example.demo.rest.Result;

import reactor.core.publisher.Mono;

@Service
public class MovieService {
	
	@Autowired
	WebClient.Builder builder;
	
	@Value("${api.key}")
    private String apiKey;
	
	public Mono<List<Result>> getMovies(String keyword) {
		String url = "https://api.themoviedb.org/3/search/movie?api_key=" + apiKey + "&query=" + keyword;
		return builder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(Movie.class) // Assuming MovieResponse is the class representing the JSON response
                .flatMapIterable(Movie::getResults)
                .collectList();
		
	}
	
}
