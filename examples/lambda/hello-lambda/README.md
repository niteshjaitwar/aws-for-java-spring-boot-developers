# Lambda Example - Hello Lambda

This project is a plain Java Lambda example built with Maven Wrapper.

## Runtime choice

As of `July 4, 2026`, AWS Lambda supports Java `25`, `21`, `17`, `11`, and `8.al2`. This sample targets `Java 21` so it aligns with the rest of this repository while still using a current Amazon Linux 2023 Lambda runtime.

## Build

```bash
./mvnw clean package
```

Windows:

```powershell
.\mvnw.cmd clean package
```

The deployment artifact is:

```text
target/hello-lambda.jar
```

## Handler

Use this handler value in the Lambda console or CLI:

```text
com.example.aws.lambda.HelloLambdaHandler
```

## Deploy with AWS CLI

```bash
aws lambda create-function \
  --function-name hello-lambda \
  --runtime java21 \
  --role arn:aws:iam::<account-id>:role/lambda-basic-execution-role \
  --handler com.example.aws.lambda.HelloLambdaHandler \
  --zip-file fileb://target/hello-lambda.jar
```

To update code later:

```bash
aws lambda update-function-code \
  --function-name hello-lambda \
  --zip-file fileb://target/hello-lambda.jar
```

See [docs/04-lambda-for-java/README.md](../../../docs/04-lambda-for-java/README.md) for the current console and CLI walkthrough.

