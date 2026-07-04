package com.example.aws.s3upload.files;

public record FileUploadResponse(
	String key,
	String bucket,
	String message
) {
}

