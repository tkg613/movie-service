
package com.example.demo.rest;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "page",
    "results",
    "total_pages",
    "total_results"
})

public class MovieResponse {

    @JsonProperty("page")
    public Integer page;
    @JsonProperty("results")
    public List<Movie> results;
    @JsonProperty("total_pages")
    public Integer totalPages;
    @JsonProperty("total_results")
    public Integer totalResults;
    
    public List<Movie> getResults() {
        return results;
    };

    
}
