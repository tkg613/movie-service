
package com.example.demo.rest;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "adult",
    "backdrop_path",
    "genre_ids",
    "id",
    "original_language",
    "original_title",
    "overview",
    "popularity",
    "poster_path",
    "release_date",
    "title",
    "video",
    "vote_average",
    "vote_count"
})

public class Movie {
	
	private List<MovieResponse> movies;

    @JsonProperty("adult")
    public Boolean adult;
    @JsonProperty("backdrop_path")
    public Object backdropPath;
    @JsonProperty("genre_ids")
    public List<Integer> genreIds;
    @JsonProperty("id")
    public Integer id;
    @JsonProperty("original_language")
    public String originalLanguage;
    @JsonProperty("original_title")
    public String originalTitle;
    @JsonProperty("overview")
    public String overview;
    @JsonProperty("popularity")
    public Double popularity;
    @JsonProperty("poster_path")
    public String posterPath;
    @JsonProperty("release_date")
    public String releaseDate;
    @JsonProperty("title")
    public String title;
    @JsonProperty("video")
    public Boolean video;
    @JsonProperty("vote_average")
    public Integer voteAverage;
    @JsonProperty("vote_count")
    public Integer voteCount;
    
    public List<MovieResponse> getMovies() {
        return movies;
    }

}
