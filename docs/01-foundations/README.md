# 01 - AWS Foundations

This section gives the minimum theory a Spring Boot developer needs before using AWS services.

## Core concepts

### Regions

A region is a physical area where AWS has multiple data centers.

### Availability Zones

Availability Zones are isolated locations inside a region.

### IAM

IAM controls who can access which AWS resources.

### EC2

EC2 gives you virtual servers in the cloud.

### S3

S3 is object storage for files, backups, static assets, and uploads.

### Lambda

Lambda runs code without managing servers directly.

## AWS mindset for Java developers

- `EC2` feels closest to a traditional VM deployment.
- `S3` is usually the simplest way to handle file storage.
- `Lambda` is useful for event-driven or lightweight backend tasks.

## Recommended order

1. Understand IAM
2. Learn region and network basics
3. Start with EC2
4. Add S3
5. Then learn Lambda

