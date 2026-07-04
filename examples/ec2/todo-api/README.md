# EC2 Example - Todo API

This is a small Spring Boot `4.1.0` REST API designed for the `EC2` deployment chapter.

## What it does

- `GET /` returns a small service summary
- `GET /actuator/health` exposes health status
- `GET /api/todos` lists todos
- `POST /api/todos` creates a todo
- `PATCH /api/todos/{id}/toggle` toggles completion

## Run locally

```bash
./mvnw spring-boot:run
```

Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

## Build the JAR

```bash
./mvnw clean package
```

The packaged JAR is created under `target/`.

## Sample requests

Create a todo:

```bash
curl -X POST http://localhost:8080/api/todos \
  -H "Content-Type: application/json" \
  -d '{"title":"Deploy this Spring Boot app on EC2"}'
```

List todos:

```bash
curl http://localhost:8080/api/todos
```

## Deploy on EC2

This project is meant to be deployed on an Amazon Linux 2023 instance with Java 21 installed.

High-level flow:

1. Launch an EC2 instance
2. Connect with `EC2 Instance Connect` or SSH
3. Install Java 21
4. Copy the JAR
5. Run it with `systemd`

See [docs/02-ec2-spring-boot-deployment/README.md](../../../docs/02-ec2-spring-boot-deployment/README.md) for the full step-by-step guide.
