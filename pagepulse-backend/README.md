# 🚀 PagePulse Backend

Spring Boot REST API for auditing websites.

---

## Features

- URL Validation
- Page Title
- Meta Description
- HTTP Status
- Response Time
- H1 Count
- Missing Image ALT Count
- Word Count
- Timeout Handling
- Non-HTML Detection
- Global Exception Handling
- Unit Tests
- Docker Support

---

## Tech Stack

- Java 21
- Spring Boot 3
- Maven
- Jsoup
- JUnit 5

---

## API Endpoint

### Audit Website

POST

```
/api/audit
```

Example Body

```json
{
  "url":"https://github.com"
}
```

---

## Running Locally

```bash
./mvnw spring-boot:run
```

Runs on

```
http://localhost:8080
```

---

## Running Tests

```bash
./mvnw test
```

---

## Docker

Build Image

```bash
docker build -t pagepulse-backend .
```

Run Container

```bash
docker run -p 8080:8080 pagepulse-backend
```

---

## Environment Variables

No environment variables are required.

---

## Live API

https://page-pulse-qy00.onrender.com
