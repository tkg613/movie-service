package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class MovieDetailController {
	
	@RequestMapping("/")
	public String movieDetail() {
		return "movieDetail";
	}
	
	
	
}
