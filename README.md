# Resource Tracking Web App
*Work in Progress - Active Development*
## Architecture
This is the backend API. The React TypeScript frontend is available at:
[github.com/Jperparas/resource-tracker-frontend](https://github.com/Jperparas/resource-tracker-frontend)
Full-stack application for tracking aircraft parking spots and ground power units 
for airline maintenance operations.

## Tech Stack
- **Backend:** Java 21, Spring Boot, JPA, MySQL, Flyway
- **Frontend:** React 19, TypeScript, Vite, TanStack Query, shadcn/ui
- **API Documentation:** Swagger/OpenAPI

## Key Features (Implemented/In Progress)
- RESTful API with intelligent audit logging
- Automated event type detection from state transitions
- Polymorphic tracking for fuel/battery/DEF levels
- Normalized database with versioned migrations

## API Documentation
Swagger UI available at `/swagger-ui.html` when running locally

---
Built to solve real-world logistics challenges from my experience 
in airline ground operations.
