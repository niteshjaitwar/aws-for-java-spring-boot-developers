# 05 - Next Steps

After learning EC2, S3, and Lambda, move into the AWS services that complete a production-ready backend.

## Recommended next services

- `API Gateway` for HTTP APIs in front of Lambda
- `RDS` for relational databases
- `CloudWatch` for logs and monitoring
- `Elastic Beanstalk` for simpler app deployment
- `ECS` for containerized applications
- `Route 53` for domain management

## Good follow-up projects

- deploy a CRUD Spring Boot API on EC2
- add S3 image upload support
- add a Lambda thumbnail generator
- add CloudWatch logs and alarms

## Best next reading in this repository

If you want one connected path instead of separate experiments, continue with:

- [docs/06-production-capstone/README.md](../06-production-capstone/README.md)

## Production mindset

As you move beyond beginner practice, focus on:

- least-privilege IAM
- cost monitoring
- logging
- backups
- infrastructure automation
- moving from click-ops to IaC with tools like AWS CloudFormation, AWS CDK, or Terraform

## Real-life learning roadmap

Once a Java developer has learned EC2, S3, and Lambda, the next confusion is usually:

"What should I study next to become useful in real projects?"

The answer is not random service collection.

It is the services that solve common production problems.

## How these services connect in a real backend

For a realistic Spring Boot product:

- `Route 53` gives the domain
- `CloudWatch` gives logs and alarms
- `RDS` stores relational data
- `API Gateway` is useful if some APIs move toward serverless
- `ECS` becomes relevant when you containerize the application

This means the next learning phase should follow architecture needs, not service popularity.

## Mini project path

Use this sequence:

1. keep your existing EC2 app
2. add `RDS` for real database hosting
3. add `CloudWatch` alarms
4. add `Route 53` and HTTPS
5. move infrastructure into Terraform
6. later compare EC2 deployment with containers on `ECS`

## Interview preparation

### Common interview questions

1. What AWS services would you add after a basic EC2 deployment to make it production-ready?
2. Why is logging and monitoring important?
3. When would ECS become a better fit than a plain EC2 deployment?

### Good answer direction

- production systems need DNS, monitoring, database strategy, and repeatable infrastructure
- logging and monitoring reduce blind debugging
- ECS becomes useful when container orchestration and repeatable multi-service deployment matter
