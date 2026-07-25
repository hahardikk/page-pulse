# 🚀 PagePulse

A lightweight full-stack web application that audits any publicly accessible webpage and returns key on-page SEO and content metrics.

The backend fetches and parses the target webpage using Jsoup, while the frontend provides a simple interface to submit URLs and display audit results.

---

## 🌐 Live Demo

### Frontend

https://page-pulse-ui.onrender.com

### Backend API

https://page-pulse-qy00.onrender.com

---

## 📸 Preview

![PagePulse Screenshot](https://github.com/user-attachments/assets/66dd890d-293f-48ec-877d-ce73581ac59e)
<img width="959" height="446" alt="image" src="https://github.com/user-attachments/assets/ef657956-c520-4ed3-a9dc-36d05fbf55ec" />
<img width="959" height="449" alt="image" src="https://github.com/user-attachments/assets/5eb9b4a6-23bb-430a-9be8-1477c8814dc0" />
<img width="959" height="449" alt="image" src="https://github.com/user-attachments/assets/59fa36ac-3e3a-4538-aade-f4e38bfd5af4" />
<img width="959" height="449" alt="image" src="https://github.com/user-attachments/assets/effa256f-6234-4a9e-9aa8-bdf7ab659228" />






---

# ✨ Features

- Validate URLs before making requests
- Fetch webpage HTML
- Measure HTTP response time
- Return HTTP status code
- Extract page title
- Extract meta description
- Count H1 headings
- Count images missing ALT attributes
- Approximate page word count
- Handle invalid URLs
- Handle request timeouts
- Handle non-HTML responses
- Global exception handling
- Unit tests
- Dockerized backend
- Responsive frontend

---

# 🛠 Tech Stack

## Backend

- Java 21
- Spring Boot 3
- Maven
- Jsoup
- JUnit 5

## Frontend

- React
- Vite
- Axios
- CSS

## Deployment

- Docker
- Render

---

# 📂 Project Structure

```
page-pulse
│
├── pagepulse-backend
│
└── page-pulse-ui
```

---

# 🚀 Running Locally

## Clone Repository

```bash
git clone https://github.com/hahardikk/page-pulse.git

cd page-pulse
```

---

## Backend

```bash
cd pagepulse-backend

./mvnw spring-boot:run
```

Runs on

```
http://localhost:8080
```

---

## Frontend

Install dependencies

```bash
cd page-pulse-ui

npm install
```

Create a `.env`

```
VITE_API_URL=http://localhost:8080/api/audit/post
```

Run

```bash
npm run dev
```

Runs on

```
http://localhost:5173
```

---

# 🌍 API Contract

## Endpoint

```
POST /api/audit/post
```

## Request

```json
{
  "url": "https://github.com"
}
```

## Successful Response

```json
{
  "status": 200,
  "responseTime": 154,
  "title": "GitHub",
  "metaDescription": "...",
  "imagesMissingAlt": 2,
  "h1Count": 1,
  "wordCount": 820
}
```

## Error Responses

### Invalid URL

```json
{
  "message": "Please provide a valid URL."
}
```

### Timeout

```json
{
  "message": "Website took too long to respond."
}
```

### Non HTML Response

```json
{
  "message": "Provided URL is not an HTML page."
}
```

---

# 🧪 Tests

Implemented tests cover:

- Successful website audit
- Invalid URL
- Non-HTML response
- Request timeout

Run tests

```bash
./mvnw test
```

---

# 🐳 Docker

Build image

```bash
docker build -t pagepulse-backend .
```

Run container

```bash
docker run -p 8080:8080 pagepulse-backend
```

---

# 💡 Design Decisions

## 1. URL Validation Before Network Calls

The application validates URLs before attempting any HTTP request. This avoids unnecessary network traffic, provides faster feedback to the user, and returns clear validation errors instead of generic connection failures.

---

## 2. Explicit Exception Handling

Instead of returning a generic server error, different failure scenarios are handled separately:

- Invalid URL
- Timeout
- Non-HTML response

This improves the user experience by providing meaningful error messages and makes debugging easier.

---

## 3. Content-Type Verification

The response Content-Type is checked before parsing HTML. This prevents attempting to parse JSON, images, PDFs, or other non-HTML resources with Jsoup, resulting in more predictable and reliable behavior.

---

# 🔍 Assumptions

- Only publicly accessible websites are supported.
- JavaScript-rendered content is not executed because Jsoup fetches server-rendered HTML.
- Word count is approximate and based on extracted visible text.

---

# 🚀 Future Improvements

If I had another day, I would implement:

- SEO scoring system
- Open Graph tag analysis
- Canonical tag detection
- Robots.txt validation
- Sitemap detection
- Broken link checking
- Lighthouse-style performance metrics
- Docker Compose for full-stack deployment
- Caching for repeated requests

---

# 👨‍💻 Author

Hardik Saini

GitHub

https://github.com/hahardikk
