# 10 - Troubleshooting Guide

This chapter helps readers debug common problems without panic.

## Author

Created for this repository by `niteshjaitwar`.

## How to use this guide

When something breaks:

1. identify which AWS service is failing
2. check the exact error message
3. compare your setup against the matching section below
4. fix one problem at a time

## EC2 problems

### I cannot connect to the instance

Check:

- instance state is `Running`
- security group allows your connection method
- you are using the correct key pair
- you are using the correct username such as `ec2-user` for Amazon Linux
- `EC2 Instance Connect` is available for your instance and networking setup

### The app runs locally but not on EC2

Check:

- Java version on EC2
- correct JAR file uploaded
- correct port in the app configuration
- `systemd` service file path
- logs with:

```bash
sudo journalctl -u todo-api -f
```

### The browser cannot reach the app

Check:

- security group inbound rules
- Nginx is running
- Spring Boot app is running
- health endpoint works locally on the instance

## S3 problems

### Upload fails with access denied

Check:

- IAM role attached to EC2
- bucket name is correct
- region is correct
- policy allows `s3:PutObject`

### Bucket exists error

S3 bucket names must be globally unique, not just unique in your account.

Use a more unique bucket name.

### Files upload but download links fail

Check:

- object key is correct
- presigned URL is generated for the same bucket and key
- clock on your local system is not badly wrong

## Lambda problems

### Create function fails

Check:

- IAM role ARN is valid
- runtime name is correct
- handler name matches your compiled class
- JAR file path is correct

### Lambda runs but returns an error

Check:

- the handler signature
- packaging result
- CloudWatch logs
- event payload shape

## Route 53 and ACM problems

### Certificate stays pending validation

Check:

- DNS validation record was actually created
- record is in the correct hosted zone
- enough time has passed for DNS propagation

### HTTPS works on the load balancer DNS name but not on the custom domain

Check:

- Route 53 alias record points to the correct ALB
- hosted zone matches the domain you are using
- browser is opening the correct domain

### Redirect loop or 502 error

Check:

- ALB listener rules
- Nginx proxy settings
- app health endpoint
- target group health status

## GitHub Actions problems

### Workflow fails on Maven Wrapper

Check:

- `mvnw` exists in the project
- workflow sets execute permission on Linux
- `pom.xml` is valid

### Workflow passes locally but fails in CI

Check:

- Java version mismatch
- environment variables missing
- path assumptions that only work on your machine

## Billing problems

### I expected free usage but see charges

Check:

- account creation date and Free Tier model
- whether the resource kept running longer than expected
- whether your service is outside the free or credit-covered usage
- whether data transfer, storage, or requests caused charges

## Good debugging habits for students

- copy the full error message
- note the service involved
- note the region involved
- check logs before changing everything
- change one thing at a time

## Real-life scenario

In real projects, cloud debugging is rarely one-layer debugging.

A request may pass through:

- DNS
- load balancer
- EC2
- Spring Boot
- S3 or Lambda

This means a strong AWS developer does not guess randomly.

They isolate the failing layer.

## Practical debugging method

Use this order when a feature breaks:

1. confirm the user-facing symptom
2. identify the AWS service involved
3. test network reachability
4. test application health
5. inspect logs
6. inspect IAM permissions if access is denied
7. change one thing and retest

## Interview preparation

### Common interview questions

1. How do you debug a Spring Boot app that works locally but fails on EC2?
2. How do you debug `AccessDenied` with S3?
3. Where do you look when a Lambda function returns an error?
4. How do you approach a multi-service production issue?

### Good answer direction

- compare runtime environment differences, logs, networking, and startup configuration
- verify IAM policy, role attachment, bucket name, and region for S3 issues
- check CloudWatch logs and handler configuration for Lambda
- isolate the failing layer instead of changing many things at once

## When to open a GitHub issue

Open an issue if:

- the command in the repo is wrong
- the code example is broken
- a doc step is unclear
- AWS renamed a current console section and the guide needs refresh

Use the issue templates in:

- [.github/ISSUE_TEMPLATE](../../.github/ISSUE_TEMPLATE)
