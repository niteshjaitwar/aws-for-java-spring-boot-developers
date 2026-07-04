# 08 - Infrastructure as Code Starter

This chapter introduces the next maturity step after manual setup: defining AWS infrastructure with code.

## Author

Created for this repository by `niteshjaitwar`.

## Why readers should learn this

Manual setup is useful for learning the AWS console.

But after that, infrastructure as code helps you:

- rebuild environments consistently
- review infrastructure changes in Git
- avoid configuration drift
- move from practice to team-friendly workflows

## What this repository includes

This repository includes a beginner-friendly Terraform starter in:

- [infra/terraform/ec2-s3-baseline/README.md](../../infra/terraform/ec2-s3-baseline/README.md)

It is intentionally simple and focused on:

- one EC2 instance
- one security group
- one IAM role for S3 access
- one private S3 bucket

## Recommended learning order

1. first complete the manual AWS setup chapters
2. understand what each AWS resource does
3. then read the Terraform starter
4. compare the Terraform resources with the manual console steps

## Terraform vs AWS CDK

### Terraform

Good for:

- cross-cloud infrastructure
- very large AWS adoption in many teams
- a clear declarative style

### AWS CDK

Good for:

- developers who want infrastructure in a programming language
- teams already deep in AWS
- sharing logic between app and infra thinking

## Why this repo starts with Terraform

For beginners, Terraform often feels easier to read line by line when the goal is understanding resources.

The Terraform starter here maps closely to the AWS console steps already taught in the repo.

## If you want CDK later

The current AWS CDK official Java path is here:

- AWS CDK home: https://docs.aws.amazon.com/cdk/v2/guide/home.html
- AWS CDK hello world: https://docs.aws.amazon.com/cdk/v2/guide/hello-world.html
- AWS CDK CLI reference: https://docs.aws.amazon.com/cdk/v2/guide/cli.html

## Important IaC best practices

- use least-privilege IAM
- do not hardcode secrets
- keep state secure
- review changes before apply
- start with a small environment first

## Official references

- Terraform AWS provider best practices: https://docs.aws.amazon.com/prescriptive-guidance/latest/terraform-aws-provider-best-practices/terraform-aws-provider-best-practices.html
- Terraform security best practices: https://docs.aws.amazon.com/prescriptive-guidance/latest/terraform-aws-provider-best-practices/security.html
- AWS CDK home: https://docs.aws.amazon.com/cdk/v2/guide/home.html

