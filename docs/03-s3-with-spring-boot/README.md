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

## Real-life scenario

A user uploads a resume, profile photo, invoice, or PDF report in your application.

That file should usually not live only on the application server.

Why:

- EC2 instances can be replaced
- local disk is not the right long-term file strategy
- multiple app servers would not share the same local files automatically

This is where S3 fits naturally.

## Practical Spring Boot scenario

Imagine a job portal built with Spring Boot:

- user profile data stays in the database
- uploaded resumes go to `S3`
- application metadata stores the S3 object key
- download access is given through a presigned URL

That design is common, scalable, and easy to explain in interviews.

## Hands-on exercise

Complete these steps with the example project:

1. create one private bucket
2. upload one test file from the application
3. list uploaded objects
4. generate one presigned URL
5. confirm the bucket is still not public

## What to say in an interview

If someone asks, "How do you store files in AWS from a Spring Boot app?", a strong answer is:

1. keep the bucket private
2. let the application upload through the AWS SDK
3. use an IAM role on EC2 or another compute service
4. store object metadata in the database if needed
5. return presigned URLs instead of exposing the bucket publicly

## Interview preparation

### Common interview questions

1. Why choose S3 over storing files on the EC2 filesystem?
2. What is a presigned URL?
3. Why should a backend bucket usually stay private?
4. Why are IAM roles preferred over access keys for S3 access from EC2?

### Good answer direction

- S3 is durable object storage and survives server replacement
- a presigned URL gives temporary controlled access to a private object
- a private bucket reduces accidental public exposure
- IAM roles are safer than embedding static secrets

## Official references

- S3 getting started: https://docs.aws.amazon.com/AmazonS3/latest/userguide/GetStartedWithS3.html
- Create a general purpose bucket: https://docs.aws.amazon.com/AmazonS3/latest/userguide/create-bucket-overview.html
- AWS SDK for Java 2.x S3 examples: https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/java_s3_code_examples.html
