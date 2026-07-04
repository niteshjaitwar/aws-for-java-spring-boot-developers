package com.example.aws.todo.todo;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@GetMapping("/")
	public Map<String, String> home() {
		return Map.of(
			"message", "Todo API is running",
			"health", "/actuator/health",
			"todos", "/api/todos"
		);
	}
}

