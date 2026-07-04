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

## Official references

- Lambda Java guide: https://docs.aws.amazon.com/lambda/latest/dg/lambda-java.html
- Lambda Java packaging: https://docs.aws.amazon.com/lambda/latest/dg/java-package.html
- Lambda Java handler guide: https://docs.aws.amazon.com/lambda/latest/dg/java-handler.html
