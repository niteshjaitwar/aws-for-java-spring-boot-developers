# 03 - Use S3 with Spring Boot

This section explains how to work with file storage using S3.

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
3. Create an IAM policy for S3 access
4. Connect Spring Boot with the AWS SDK
5. Upload files from your application
6. Download or generate access URLs

## Important concepts

- bucket
- object
- key
- public vs private access
- IAM policies
- lifecycle rules

## What to be careful about

- public bucket misconfiguration
- storing secrets in code
- uploading very large files without validation

