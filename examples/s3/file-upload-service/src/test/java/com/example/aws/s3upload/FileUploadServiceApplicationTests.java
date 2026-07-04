package com.example.aws.s3upload;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.example.aws.s3upload.config.S3Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
	"app.aws.region=us-east-1",
	"app.s3.bucket-name=test-bucket",
	"app.s3.presign-duration=15m"
})
class FileUploadServiceApplicationTests {

	@Autowired
	private S3Properties s3Properties;

	@Test
	void contextLoads() {
		assertThat(this.s3Properties.bucketName()).isEqualTo("test-bucket");
	}

}
