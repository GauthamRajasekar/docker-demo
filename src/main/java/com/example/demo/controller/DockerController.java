package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerController {
	
	@GetMapping("/test-docker")
	public String getData() {
		return "Docker Spring Boot Project Started";
	}

}
