package com.example.aws.s3upload.files;

import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.aws.s3upload.config.S3Properties;

import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Request;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;

@Service
public class S3StorageService {

	private final S3Client s3Client;
	private final S3Presigner s3Presigner;
	private final S3Properties s3Properties;

	public S3StorageService(S3Client s3Client, S3Presigner s3Presigner, S3Properties s3Properties) {
		this.s3Client = s3Client;
		this.s3Presigner = s3Presigner;
		this.s3Properties = s3Properties;
	}

	public FileUploadResponse upload(MultipartFile file) throws IOException {
		String key = buildObjectKey(file.getOriginalFilename());
		PutObjectRequest request = PutObjectRequest.builder()
			.bucket(this.s3Properties.bucketName())
			.key(key)
			.contentType(file.getContentType())
			.build();

		this.s3Client.putObject(request, RequestBody.fromBytes(file.getBytes()));
		return new FileUploadResponse(key, this.s3Properties.bucketName(), "File uploaded to S3");
	}

	public List<FileSummary> listFiles() {
		ListObjectsV2Request request = ListObjectsV2Request.builder()
			.bucket(this.s3Properties.bucketName())
			.maxKeys(50)
			.build();

		return this.s3Client.listObjectsV2(request).contents().stream()
			.map(object -> new FileSummary(object.key(), object.size()))
			.toList();
	}

	public PresignedDownloadResponse createDownloadUrl(String key) {
		GetObjectRequest objectRequest = GetObjectRequest.builder()
			.bucket(this.s3Properties.bucketName())
			.key(key)
			.build();

		GetObjectPresignRequest presignRequest = GetObjectPresignRequest.builder()
			.signatureDuration(this.s3Properties.presignDuration())
			.getObjectRequest(objectRequest)
			.build();

		URL url = this.s3Presigner.presignGetObject(presignRequest).url();
		return new PresignedDownloadResponse(key, url.toString());
	}

	private String buildObjectKey(String originalFilename) {
		String safeName = (originalFilename == null || originalFilename.isBlank()) ? "file.bin" : originalFilename.replace(" ", "-");
		return Instant.now().toEpochMilli() + "-" + safeName;
	}
}

