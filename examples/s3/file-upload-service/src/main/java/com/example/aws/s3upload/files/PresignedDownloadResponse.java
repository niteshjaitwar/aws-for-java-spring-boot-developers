package com.example.aws.s3upload.files;

public record PresignedDownloadResponse(
	String key,
	String url
) {
}

