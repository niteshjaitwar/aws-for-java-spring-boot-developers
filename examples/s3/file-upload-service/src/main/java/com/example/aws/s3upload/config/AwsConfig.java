package com.example.aws.s3upload.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;

@Configuration
@EnableConfigurationProperties(S3Properties.class)
public class AwsConfig {

	@Bean
	Region awsRegion(@Value("${app.aws.region}") String awsRegion) {
		return Region.of(awsRegion);
	}

	@Bean
	S3Client s3Client(Region region) {
		return S3Client.builder()
			.region(region)
			.build();
	}

	@Bean
	S3Presigner s3Presigner(Region region) {
		return S3Presigner.builder()
			.region(region)
			.build();
	}
}

