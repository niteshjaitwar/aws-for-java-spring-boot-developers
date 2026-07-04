# 01 - AWS Foundations

This section gives the minimum theory a Spring Boot developer needs before using AWS services.

## Core concepts

### Regions

A region is a physical area where AWS has multiple data centers.

### Availability Zones

Availability Zones are isolated locations inside a region.

### IAM

IAM controls who can access which AWS resources.

For human access, current AWS guidance prefers temporary credentials and federation over long-lived IAM user credentials.

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
- `IAM roles` are preferred over hardcoded keys.

## Recommended order

1. Understand IAM
2. Learn region and network basics
3. Start with EC2
4. Add S3
5. Then learn Lambda

## Recommended CLI habit

Use named profiles and check identity before running commands:

```bash
aws sts get-caller-identity --profile your-profile-name
```

## Real-life scenario

Suppose your company is building an e-commerce backend in Spring Boot.

The team stores product images in S3, runs the API on EC2, and uses Lambda for lightweight background processing.

A developer who does not understand regions, IAM, and basic service purpose will make bad decisions such as:

- putting credentials directly in application properties
- choosing the wrong service for the workload
- deploying resources in the wrong region
- confusing server storage with object storage

This chapter exists to prevent those mistakes.

## Service comparison for Java developers

### EC2 in real life

Use EC2 when your application behaves like a traditional server:

- long-running Spring Boot API
- custom OS packages
- full control over JVM flags
- stable traffic pattern

### S3 in real life

Use S3 when the data is file-like:

- profile pictures
- invoices
- PDF reports
- backups

### Lambda in real life

Use Lambda when the work is event-driven:

- image resize after upload
- scheduled cleanup
- webhook processing
- short background jobs

## Practical example

Think about a food delivery application:

- `EC2` hosts the main order API
- `S3` stores restaurant menu images
- `Lambda` sends a notification or processes an uploaded file
- `IAM` controls which component can access which AWS resource

That is how AWS services are usually combined.

Not as isolated chapters.

As one system.

## Hands-on exercise

Write down answers for your own sample project:

1. which part should run on `EC2`
2. which files should go to `S3`
3. which short task could move to `Lambda`
4. which AWS identity should your local machine use
5. which region you will use and why

If you can answer those clearly, you are starting to think like an AWS engineer.

## Interview preparation

### Common interview questions

1. What is the difference between a region and an availability zone?
2. Why would you choose S3 instead of storing files on the EC2 instance?
3. When would you choose Lambda instead of EC2?
4. Why are IAM roles preferred over access keys on EC2?

### Good answer direction

- a region is a geographic area and availability zones are isolated data center groups inside that region
- S3 is durable object storage and decouples files from the server lifecycle
- Lambda is better for event-driven, short, or bursty tasks
- IAM roles remove the need to hardcode static credentials
