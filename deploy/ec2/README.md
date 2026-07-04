# EC2 Production Assets

This folder contains real deployment assets you can copy to an EC2 instance:

- `systemd/todo-api.service`: keeps the Spring Boot API running after reboot
- `nginx/todo-api.conf`: reverse proxy from port `80` to the app on port `8080`

Use these files together with:

- [docs/02-ec2-spring-boot-deployment/README.md](../../docs/02-ec2-spring-boot-deployment/README.md)
- [docs/06-production-capstone/README.md](../../docs/06-production-capstone/README.md)

