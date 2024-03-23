package com.example.demo.rest;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"backdrops",
	"id",
	"logos",
	"posters"
})

public class MovieImageResponse {

	@JsonProperty("id")
	public Integer id;
	@JsonProperty("posters")
	public List<Poster> posters;
	
	public List<Poster> getResults() {
        return posters;
    };
    
    public List<Poster> getPosters() {
    	return posters;
    }

}