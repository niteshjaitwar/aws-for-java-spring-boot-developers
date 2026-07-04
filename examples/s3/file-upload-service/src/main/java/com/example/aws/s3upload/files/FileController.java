package com.example.aws.s3upload.files;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/files")
public class FileController {

	private final S3StorageService storageService;

	public FileController(S3StorageService storageService) {
		this.storageService = storageService;
	}

	@GetMapping
	public List<FileSummary> listFiles() {
		return this.storageService.listFiles();
	}

	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public FileUploadResponse upload(@RequestParam("file") MultipartFile file) {
		if (file.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "File must not be empty");
		}

		try {
			return this.storageService.upload(file);
		}
		catch (IOException exception) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to upload file", exception);
		}
	}

	@GetMapping("/{key}/download-url")
	public PresignedDownloadResponse createDownloadUrl(@PathVariable String key) {
		return this.storageService.createDownloadUrl(key);
	}

	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity<Map<String, String>> handle(ResponseStatusException exception) {
		return ResponseEntity.status(exception.getStatusCode())
			.body(Map.of("error", exception.getReason() == null ? "Request failed" : exception.getReason()));
	}
}
