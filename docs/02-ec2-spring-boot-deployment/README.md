# 02 - Deploy Spring Boot on EC2

This section covers the most familiar AWS deployment path for a Spring Boot developer.

## Goal

Take a Spring Boot application and run it on an EC2 instance.

## High-level flow

1. Launch an EC2 instance
2. Open required ports in the security group
3. Connect with SSH
4. Install Java
5. Copy the Spring Boot JAR
6. Run the application
7. Make it restart automatically on reboot

## Suggested stack

- Amazon Linux or Ubuntu
- Java 17 or Java 21
- Spring Boot executable JAR
- `systemd` for process management
- optional `nginx` as reverse proxy

## What you should learn here

- EC2 instance types
- security groups
- SSH access
- public IP vs elastic IP
- app startup and process management

## Common beginner mistakes

- opening every port to the internet
- using the root AWS account
- forgetting to persist the process after SSH disconnect
- not tracking EC2 costs

