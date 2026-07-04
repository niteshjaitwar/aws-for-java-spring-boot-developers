package com.example.aws.s3upload.files;

public record FileSummary(
	String key,
	long size
) {
}

