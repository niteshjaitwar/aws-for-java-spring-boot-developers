# Screenshots Guide

This repository uses custom diagrams instead of hardcoded AWS console screenshots by default.

Why:

- AWS console screens change often
- screenshots become outdated faster than text
- account-specific details can expose sensitive information

## Recommended screenshot set

If you want to enrich the repository with your own screenshots, capture these:

1. AWS sign-in page with `Root user` selected
2. `Security credentials` page showing MFA setup entry point
3. `Billing and Cost Management` budget creation page
4. EC2 `Launch instance` page
5. EC2 `Connect` page showing `EC2 Instance Connect`
6. S3 `Create bucket` page with default security settings
7. Lambda `Create function` page for Java runtime
8. Route 53 hosted zone page
9. ACM certificate request page
10. Application Load Balancer listener page
11. CloudWatch log group page
12. GitHub Actions workflow success screen

## Screenshot rules

- blur or remove account IDs, public IPs, and domain ownership details if needed
- avoid showing secrets, tokens, or access keys
- use wide screenshots with readable section labels
- save screenshots as `.png`

## Suggested folder naming

```text
assets/screenshots/
+-- 00-account-root-signin.png
+-- 01-account-mfa.png
+-- 02-budget-alert.png
+-- 03-ec2-launch-instance.png
+-- 04-ec2-instance-connect.png
+-- 05-s3-create-bucket.png
+-- 06-lambda-create-function.png
+-- 07-route53-hosted-zone.png
+-- 08-acm-request-certificate.png
+-- 09-alb-https-listener.png
+-- 10-cloudwatch-log-group.png
+-- 11-github-actions-success.png
```

## Best practice

Use screenshots only to support the written guide, not replace it.

