package com.example.aws.s3upload.files;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@GetMapping("/")
	public Map<String, String> home() {
		return Map.of(
			"message", "File upload service is running",
			"upload", "POST /api/files",
			"list", "GET /api/files"
		);
	}
}

