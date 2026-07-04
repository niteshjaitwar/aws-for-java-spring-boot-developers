# 04 - Lambda for Java

This section introduces serverless development for Java developers using the current Lambda console flow and current Java runtime options.

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
3. Package the function into a deployable artifact
4. Deploy it to AWS
5. Test it with sample events

## Current runtime note

As of `July 4, 2026`, the Lambda Java runtime page lists `java25`, `java21`, `java17`, `java11`, and `java8.al2`.

This repository uses `java21` for the sample so the Lambda example stays aligned with the `EC2` and `S3` projects.

## Current Lambda console flow

1. Open `Lambda`
2. Choose `Create function`
3. Choose `Author from scratch`
4. Enter `Function name`
5. Select `Runtime`
6. Choose or create an execution role
7. Choose `Create function`

## Build and deploy the sample

Build:

```bash
./mvnw clean package
```

Create the function:

```bash
aws lambda create-function \
  --function-name hello-lambda \
  --runtime java21 \
  --role arn:aws:iam::<account-id>:role/lambda-basic-execution-role \
  --handler com.example.aws.lambda.HelloLambdaHandler \
  --zip-file fileb://target/hello-lambda.jar
```

Update code later:

```bash
aws lambda update-function-code \
  --function-name hello-lambda \
  --zip-file fileb://target/hello-lambda.jar
```

Invoke from the CLI:

```bash
aws lambda invoke \
  --function-name hello-lambda \
  --payload '{}' \
  response.json
cat response.json
```

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

## Real-life scenario

A user uploads an image through your Spring Boot app.

You do not want the main API request to spend time resizing that image.

Instead:

1. the file lands in `S3`
2. an event can trigger `Lambda`
3. Lambda resizes the image or writes a small audit record

This is one of the most common real-world Lambda patterns.

## Practical example for Java developers

Imagine an online document platform:

- the main API runs on `EC2`
- user files go to `S3`
- a Java `Lambda` extracts metadata or sends a notification

That separation keeps the main application simpler and makes background work easier to scale.

## Hands-on exercise

After creating the sample function:

1. invoke it from the AWS Console
2. invoke it from the CLI
3. inspect the CloudWatch logs
4. update the code and redeploy it
5. explain in one sentence why this work could be Lambda instead of EC2

## Interview preparation

### Common interview questions

1. What kinds of workloads fit Lambda well?
2. Why is Lambda often used with S3 events?
3. Why can Java cold starts matter in Lambda?
4. When would you choose EC2 instead of Lambda?

### Good answer direction

- Lambda fits short-lived, event-driven, and bursty tasks
- S3 can trigger Lambda automatically after object events
- Java functions may have higher startup overhead than lighter runtimes
- EC2 is better for long-running APIs or workloads needing full server control

## Official references

- Lambda Java guide: https://docs.aws.amazon.com/lambda/latest/dg/lambda-java.html
- Lambda Java packaging: https://docs.aws.amazon.com/lambda/latest/dg/java-package.html
- Lambda Java handler guide: https://docs.aws.amazon.com/lambda/latest/dg/java-handler.html
