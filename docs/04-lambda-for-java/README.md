# 04 - Lambda for Java

This section introduces serverless development for Java developers.

## Goal

Build and deploy a simple Java-based AWS Lambda function and understand where it fits in a real architecture.

## What Lambda is good for

- event-driven processing
- lightweight APIs
- scheduled jobs
- file-processing workflows

## Learning flow

1. Understand the Lambda execution model
2. Create a Java handler
3. Package the function
4. Deploy it to AWS
5. Test it with sample events

## Java-specific notes

- cold starts matter more in Java than in lighter runtimes
- package size should stay lean
- functions should do one focused job

## When to choose Lambda

Use Lambda when:

- you do not want to manage servers
- the workload is event-driven
- scaling demand is unpredictable

Prefer EC2 when:

- you need a long-running Spring Boot service
- you want full OS-level control
- the application is already designed as a traditional web server

