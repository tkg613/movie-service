package com.example.demo.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"aspect_ratio",
	"height",
	"iso_639_1",
	"file_path",
	"vote_average",
	"vote_count",
	"width"
})

public class Poster {
	
	@JsonProperty("aspect_ratio")
	public Double aspectRatio;
	@JsonProperty("height")
	public Integer height;
	@JsonProperty("iso_639_1")
	public String iso6391;
	@JsonProperty("file_path")
	public String filePath;
	@JsonProperty("vote_average")
	public Integer voteAverage;
	@JsonProperty("vote_count")
	public Integer voteCount;
	@JsonProperty("width")
	public Integer width;

	public String getFilePath() {
		return filePath;
	}
	
}