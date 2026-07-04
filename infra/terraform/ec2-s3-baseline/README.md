# Terraform Starter - EC2 + S3 Baseline

This Terraform starter mirrors the beginner AWS path in this repository.

## What it creates

- one EC2 instance
- one security group
- one IAM role and instance profile
- one private S3 bucket

## Why this example is useful

It helps readers connect:

- what they clicked in the AWS console
- with how the same infrastructure looks in code

## Files

- `versions.tf`
- `variables.tf`
- `main.tf`
- `outputs.tf`
- `terraform.tfvars.example`
- `user_data.sh`

## Before you use it

You need:

- Terraform installed locally
- AWS credentials configured
- an existing key pair name in AWS
- a subnet ID and VPC ID in your target region

## Basic flow

```bash
terraform init
terraform plan -var-file="terraform.tfvars"
terraform apply -var-file="terraform.tfvars"
```

## Notes

- this repository environment does not currently have Terraform installed, so the files were scaffolded but not validated by running `terraform validate`
- review the values carefully before applying in a real AWS account

