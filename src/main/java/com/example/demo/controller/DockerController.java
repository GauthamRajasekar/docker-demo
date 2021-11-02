package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class DockerController {
	
	@GetMapping("/test-docker")
	public String getData() {
		return "Docker Spring Boot Project Started";
	}

	@GetMapping(value="/test")
	public String getValue(@RequestParam String param) {
		return "Test";
	}
	
}
