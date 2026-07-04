# 00 - AWS Account Setup

This section helps a complete beginner create an AWS account safely using the current AWS sign-in and console flow.

## Goal

Create an AWS account, secure it, and prepare it for learning without unnecessary risk.

## Step-by-step

1. Go to the AWS sign-up page and create an account.
2. Add a payment method and finish phone or identity verification.
3. Sign in to the AWS Management Console by choosing `Root user` and entering your account email.
4. Open your account menu and choose `Security credentials`.
5. Enable `MFA` for the root user.
6. Open `Account` from the top-right account menu.
7. In `IAM User and Role Access to Billing Information`, choose `Edit`, then enable `Activate IAM Access`.
8. Open `Billing and Cost Management` and create a budget.
9. For daily access, prefer `IAM Identity Center` or create an IAM admin user if you are using a simple single-account beginner setup.
10. Stop using the root user except for root-only tasks.

## Current best-practice notes

- AWS recommends temporary credentials for human users instead of long-lived IAM user credentials.
- For local CLI access, prefer `aws configure sso`.
- Do not create root access keys.
- Keep budget alerts enabled from day one.
- For a beginner single-account setup, an IAM admin user is still common, but it should not be your long-term production model.

## Suggested console path

1. `Root user` sign-in
2. `Security credentials`
3. `Account`
4. `Billing and Cost Management`
5. `IAM Identity Center` or `IAM`

## AWS CLI setup for learners

If you configure IAM Identity Center, the current recommended CLI flow is:

```bash
aws configure sso
aws sso login --profile your-profile-name
aws sts get-caller-identity --profile your-profile-name
```

If you are using a simple IAM user for practice, then use:

```bash
aws configure
aws sts get-caller-identity
```

## Why this matters

Beginners often skip security and billing controls. That is a mistake. The first AWS lesson should be account safety and cost visibility.

## Recommended outcome

By the end of this section, you should have:

- one active AWS account
- MFA enabled
- one safe daily-access method
- budget alerts configured

## Official references

- AWS account setup: https://docs.aws.amazon.com/IAM/latest/UserGuide/getting-started-account-iam.html
- Root user best practices: https://docs.aws.amazon.com/IAM/latest/UserGuide/root-user-best-practices.html
- Create a cost budget: https://docs.aws.amazon.com/cost-management/latest/userguide/create-cost-budget.html
- AWS CLI SSO configuration: https://docs.aws.amazon.com/cli/latest/userguide/cli-configure-sso.html
