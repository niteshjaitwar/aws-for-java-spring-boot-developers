# 03 - Use S3 with Spring Boot

This section explains how to work with file storage using S3 using current S3 defaults and the AWS SDK for Java 2.x.

## Goal

Upload, store, and retrieve files from an S3 bucket using a Spring Boot application.

## Typical use cases

- profile image uploads
- document storage
- static file hosting
- backups

## Learning flow

1. Create an S3 bucket
2. Understand bucket naming and region choice
3. Keep current secure defaults unless you have a reason to change them
4. Create an IAM role or policy for S3 access
5. Connect Spring Boot with the AWS SDK for Java 2.x
6. Upload files from your application
7. Download files or generate presigned URLs

## Current S3 bucket creation notes

On the current `Create bucket` page:

- bucket names must be globally unique
- `Object Ownership` defaults to `Bucket owner enforced`
- `ACLs` are disabled by default
- `Block Public Access` should stay enabled for most backend application buckets

For this repository, keep the bucket private.

## Important concepts

- bucket
- object
- key
- private access and presigned URLs
- IAM policies
- lifecycle rules

## Recommended local development flow

1. Authenticate with:

```bash
aws configure sso
aws sso login --profile your-profile-name
```

2. Export configuration:

```bash
export AWS_PROFILE=your-profile-name
export AWS_REGION=us-east-1
export APP_S3_BUCKET_NAME=your-unique-bucket-name
```

3. Run the application:

```bash
./mvnw spring-boot:run
```

## Recommended deployment flow on EC2

Do not put access keys in the application configuration.

Instead:

1. Create an IAM role for the EC2 instance
2. Grant only the required S3 permissions
3. Attach the role to the instance
4. Let the AWS SDK use instance credentials automatically

## What to be careful about

- public bucket misconfiguration
- storing secrets in code
- uploading very large files without validation

## Official references

- S3 getting started: https://docs.aws.amazon.com/AmazonS3/latest/userguide/GetStartedWithS3.html
- Create a general purpose bucket: https://docs.aws.amazon.com/AmazonS3/latest/userguide/create-bucket-overview.html
- AWS SDK for Java 2.x S3 examples: https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/java_s3_code_examples.html
