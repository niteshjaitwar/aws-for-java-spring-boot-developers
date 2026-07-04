# 02 - Deploy Spring Boot on EC2

This section covers the most familiar AWS deployment path for a Spring Boot developer using the current EC2 console flow and Amazon Linux 2023.

## Goal

Take a Spring Boot application and run it on an EC2 instance.

## High-level flow

1. Launch an EC2 instance
2. Review `Network settings` and open only the ports you need
3. Connect with `EC2 Instance Connect` or SSH
4. Install Java 21 on Amazon Linux 2023
5. Copy the Spring Boot JAR
6. Run the application
7. Make it restart automatically on reboot with `systemd`

## Suggested stack

- Amazon Linux 2023
- Java 21
- Spring Boot executable JAR
- `systemd` for process management
- optional `nginx` as reverse proxy

## Current EC2 console labels

When you launch an instance in the current EC2 console, you will typically work through these sections:

1. `Name and tags`
2. `Application and OS Images (Amazon Machine Image)`
3. `Instance type`
4. `Key pair (login)`
5. `Network settings`
6. `Configure storage`
7. `Advanced details`

## Recommended beginner launch settings

- AMI: `Amazon Linux 2023`
- Instance type: a free-tier-eligible or low-cost option for practice
- Inbound rules:
  - `SSH` only from your IP when using SSH
  - `Custom TCP 8080` only if you want to expose the Spring Boot app directly
  - prefer `HTTP 80` if you place `nginx` in front of the app

## Connect to the instance

Console path:

1. Open `EC2`
2. Choose `Instances`
3. Select your instance
4. Choose `Connect`
5. Use the `EC2 Instance Connect` tab if available

CLI option with AWS CLI v2:

```bash
aws ec2-instance-connect ssh --instance-id i-1234567890example
```

## Install Java 21 on Amazon Linux 2023

```bash
sudo dnf update -y
sudo dnf install java-21-amazon-corretto-devel git -y
java -version
```

## Build and copy the app

Build locally:

```bash
./mvnw clean package
```

Copy the JAR:

```bash
scp -i /path/to/key.pem target/todo-api-0.0.1-SNAPSHOT.jar ec2-user@PUBLIC_IP:/home/ec2-user/app.jar
```

## Run with systemd

Create `/etc/systemd/system/todo-api.service`:

```ini
[Unit]
Description=Todo API
After=network.target

[Service]
User=ec2-user
WorkingDirectory=/home/ec2-user
ExecStart=/usr/bin/java -jar /home/ec2-user/app.jar
SuccessExitStatus=143
Restart=always
RestartSec=5

[Install]
WantedBy=multi-user.target
```

Then enable and start it:

```bash
sudo systemctl daemon-reload
sudo systemctl enable todo-api
sudo systemctl start todo-api
sudo systemctl status todo-api
```

On Amazon Linux 2023, use `journalctl` for logs:

```bash
sudo journalctl -u todo-api -f
```

## What you should learn here

- EC2 instance types
- security groups
- EC2 Instance Connect and SSH access
- public IP vs elastic IP
- app startup and process management

## Common beginner mistakes

- opening every port to the internet
- using the root AWS account
- forgetting to persist the process after SSH disconnect
- not tracking EC2 costs

## Official references

- EC2 getting started: https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/EC2_GetStarted.html
- EC2 Instance Connect: https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ec2-instance-connect-methods.html
- Amazon Linux 2023 Java: https://docs.aws.amazon.com/corretto/latest/corretto-21-ug/amazon-linux-install.html
