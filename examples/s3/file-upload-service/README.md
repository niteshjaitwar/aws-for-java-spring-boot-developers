# S3 Example - File Upload Service

This is a Spring Boot `4.1.0` example that uploads files to `Amazon S3` using the `AWS SDK for Java 2.x`.

## What it does

- `GET /` returns a service summary
- `GET /api/files` lists objects from the bucket
- `POST /api/files` uploads a multipart file
- `GET /api/files/{key}/download-url` returns a presigned download URL

## Configuration

Set these values before running:

```bash
export AWS_REGION=us-east-1
export APP_S3_BUCKET_NAME=your-unique-bucket-name
```

Windows PowerShell:

```powershell
$env:AWS_REGION="us-east-1"
$env:APP_S3_BUCKET_NAME="your-unique-bucket-name"
```

For local development, prefer `aws configure sso` and temporary credentials instead of long-lived access keys.

## Run locally

```bash
./mvnw spring-boot:run
```

Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

## Upload a file

```bash
curl -X POST http://localhost:8080/api/files \
  -F "file=@./sample.pdf"
```

## Production note

When this app runs on `EC2`, do not hardcode AWS keys. Attach an IAM role to the instance with only the S3 permissions the app needs.

See [docs/03-s3-with-spring-boot/README.md](../../../docs/03-s3-with-spring-boot/README.md) for the full setup guide.
