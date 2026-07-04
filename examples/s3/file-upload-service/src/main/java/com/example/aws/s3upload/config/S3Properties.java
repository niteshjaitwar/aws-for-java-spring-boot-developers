package com.example.aws.s3upload.config;

import java.time.Duration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.s3")
public record S3Properties(
	String bucketName,
	Duration presignDuration
) {
}

