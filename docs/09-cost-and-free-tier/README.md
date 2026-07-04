# 09 - Cost Guide and AWS Free Tier Notes

This chapter helps readers learn AWS in a low-cost, student-friendly way.

## Author

Created for this repository by `niteshjaitwar`.

## Why this chapter matters

Many beginners are not blocked by code.

They are blocked by fear of surprise charges.

This guide explains how to learn carefully and cheaply.

## Current AWS Free Tier note

Based on official AWS sources reviewed on `July 4, 2026`:

- new AWS customers can choose a `Free plan` or `Paid plan`
- AWS states that new customers receive `USD $100` in sign-up credits
- AWS also states that customers can earn `up to an additional USD $100` in credits
- AWS states that the `Free plan` is available for `6 months` after account creation

This means the AWS Free Tier changed compared with older tutorials that only talk about a simple fixed 12-month beginner story.

## Important date split

AWS documentation separates customers into two groups:

- accounts created `before July 15, 2025`
- accounts created `after July 15, 2025`

If a learner is following an older blog post, they might be reading the wrong Free Tier rules.

## What to tell students clearly

For learning purpose:

- start small
- keep budgets enabled
- track Free Tier usage often
- shut resources down when done
- delete practice resources you no longer need

## Free learning path mindset

### Lowest-risk services in this repository

- reading documentation
- using AWS Skill Builder free training
- small `Lambda` tests
- small `S3` experiments

### Higher-risk learning steps

- leaving `EC2` running for days
- opening public networking without checking usage
- testing large file uploads repeatedly
- using additional services outside the guide

## What AWS says is free right now

From the current AWS sources reviewed on `July 4, 2026`:

- AWS Free Tier includes free credits for new customers
- EC2 pricing page states AWS customers receive `100 GB` of free data transfer out to the internet each month, aggregated across eligible AWS services and regions
- Lambda pricing page states the free tier includes `1 million requests per month`

For S3, AWS pricing pages now emphasize credit-based Free Tier language for new accounts instead of older fixed beginner messaging.

## Safe budget setup for learners

Create these at the start:

1. one monthly cost budget
2. one forecasted budget alert
3. one notification email that you actually read

Suggested personal warning thresholds:

- `USD $1`
- `USD $5`
- `USD $10`

The exact amount is your choice, but the point is early warning.

## Free or low-cost study plan for students

### Path A - No pressure path

- read the docs
- use AWS Training and Certification free courses
- use AWS Skill Builder free resources
- explore console screens without launching many resources

### Path B - Hands-on path

- create one EC2 instance
- build one small Spring Boot app
- upload only a few test files to S3
- run a few Lambda invocations
- delete practice resources after each learning session

## Student-friendly weekly habit

At the end of each week:

1. open `Billing and Cost Management`
2. check your month-to-date cost
3. check active services
4. stop or delete what you no longer need

## Track Free Tier usage

AWS provides multiple ways to monitor this.

Readers should learn these pages early:

- billing dashboard
- Free Tier tracking pages
- EC2 dashboard Free Tier box

## Practical cost warnings for this repository

### EC2

Most likely cost risk in this repo because compute keeps running until you stop or terminate it.

### S3

Usually low-cost for small learning usage, but large uploads and high request volume can add up.

### Lambda

Usually beginner-friendly for light usage because the free request tier is generous for small experiments.

## Student resources from AWS

Current AWS learning resources reviewed on `July 4, 2026`:

- AWS Training and Certification offers hundreds of free digital courses
- AWS Skill Builder offers many free learning resources
- AWS Academy offers free curriculum through participating higher education institutions
- AWS Training Events and AWS Skills Centers offer free classes and events

## What this means for learners

If a student wants to learn AWS without spending much:

- use free AWS training first
- use the repo's diagrams and docs next
- then move into the smallest possible hands-on experiments

## Real-life scenario

A student creates an EC2 instance on Friday, forgets about it, and checks the account two weeks later.

That is one of the most common beginner AWS mistakes.

This chapter exists so learners understand that cloud skill includes cost awareness, not just service knowledge.

## Practical budget exercise

Before you do the next AWS lab:

1. confirm your account creation date
2. read the correct Free Tier model for that date
3. create one monthly budget
4. create one forecast alert
5. decide which resource you will delete immediately after practice

## Interview preparation

### Common interview questions

1. What AWS cost risk is most common for beginners?
2. Why should EC2 be treated more carefully than light Lambda experiments?
3. How would you keep a training account under control?

### Good answer direction

- running compute longer than intended is a common cost problem
- EC2 continues billing while active, while small Lambda usage is often lower risk for learning
- budgets, alerts, cleanup discipline, and free-tier tracking are basic cost controls

## Official references

- AWS Free Tier overview: https://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/free-tier.html
- Choose a Free Tier plan: https://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/free-tier-plans.html
- Free Tier eligibility: https://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/free-tier-eligibility.html
- Track Free Tier usage: https://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/tracking-free-tier-usage.html
- Free Tier API: https://docs.aws.amazon.com/awsaccountbilling/latest/aboutv2/using-free-tier-api.html
- EC2 pricing: https://aws.amazon.com/ec2/pricing/on-demand/
- EC2 Free Tier tracking: https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-free-tier-usage.html
- S3 pricing: https://aws.amazon.com/s3/pricing/
- Lambda pricing: https://aws.amazon.com/lambda/pricing/
- AWS Training and Certification: https://aws.amazon.com/training/
- AWS Skill Builder: https://skillbuilder.aws/
- AWS Academy: https://aws.amazon.com/training/awsacademy/
- AWS Training Events: https://aws.amazon.com/training/events/
- AWS Skills Centers: https://aws.amazon.com/training/skills-centers/
