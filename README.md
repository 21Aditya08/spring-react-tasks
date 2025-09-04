# 🚀 Task Manager - Full-Stack Application

A modern, full-stack task management application built with **Spring Boot**, **MySQL**, and **React TypeScript**.

![Task Manager](https://img.shields.io/badge/Spring%20Boot-3.3.2-brightgreen)
![React](https://img.shields.io/badge/React-18.2.0-blue)
![TypeScript](https://img.shields.io/badge/TypeScript-4.9.5-blue)
![MySQL](https://img.shields.io/badge/MySQL-8.0-orange)
![TailwindCSS](https://img.shields.io/badge/TailwindCSS-3.4.17-blue)

## ✨ Features

- 📝 **Full CRUD Operations** - Create, Read, Update, Delete tasks
- 🔍 **Search Functionality** - Search tasks by title
- 🎨 **Modern UI** - Responsive design with Tailwind CSS
- 📊 **Status Management** - Track task status (Pending, In Progress, Completed)
- 🎯 **Real-time Updates** - Instant UI updates with optimistic responses
- 🔄 **RESTful API** - Clean API architecture with proper HTTP status codes
- 🛡️ **Input Validation** - Both frontend and backend validation
- 📱 **Mobile Responsive** - Works seamlessly on all devices

## 🏗️ Architecture

### Backend (Spring Boot)
```
├── controller/     # REST API endpoints
├── service/       # Business logic
├── repository/    # Data access layer
├── entity/        # JPA entities
├── dto/          # Data transfer objects
└── exception/    # Global exception handling
```

### Frontend (React TypeScript)
```
├── components/   # Reusable UI components
├── pages/       # Main application pages
├── services/    # API service layer
├── types/       # TypeScript type definitions
└── styles/      # Tailwind CSS configurations
```

## 🚀 Quick Start

### Prerequisites
- **Java 17+**
- **Maven 3.6+**
- **MySQL 8.0+**
- **Node.js 16+**
- **npm 8+**

### Backend Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/21Aditya08/spring-react-tasks.git
   cd spring-react-tasks/task-manager-backend
   ```

2. **Configure MySQL Database**
   ```sql
   CREATE DATABASE task_manager_db;
   ```

3. **Update application.properties**
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/task_manager_db
   spring.datasource.username=root
   spring.datasource.password=root
   ```

4. **Run the backend**
   ```bash
   ./mvnw spring-boot:run
   ```
   Backend will be available at `http://localhost:8081`

### Frontend Setup

1. **Navigate to frontend directory**
   ```bash
   cd ../task-manager-frontend
   ```

2. **Install dependencies**
   ```bash
   npm install
   ```

3. **Start the development server**
   ```bash
   npm start
   ```
   Frontend will be available at `http://localhost:3000`

## 📡 API Documentation

### Base URL: `http://localhost:8081/api`

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/tasks` | Get all tasks |
| GET | `/tasks?title={query}` | Search tasks by title |
| GET | `/tasks/{id}` | Get task by ID |
| POST | `/tasks` | Create new task |
| PUT | `/tasks/{id}` | Update existing task |
| DELETE | `/tasks/{id}` | Delete task |

### Task Object Structure
```json
{
  "id": 1,
  "title": "Complete project documentation",
  "description": "Write comprehensive README and API docs",
  "status": "IN_PROGRESS",
  "createdAt": "2025-09-04T10:30:00Z",
  "updatedAt": "2025-09-04T10:30:00Z"
}
```

## 🛠️ Technology Stack

### Backend
- **Spring Boot 3.3.2** - Application framework
- **Spring Data JPA** - Data persistence
- **MySQL** - Database
- **Maven** - Build tool
- **Hibernate** - ORM
- **Java 17** - Programming language

### Frontend
- **React 18.2.0** - UI framework
- **TypeScript 4.9.5** - Type safety
- **Tailwind CSS 3.4.17** - Styling
- **Axios** - HTTP client
- **React Router DOM** - Navigation *(planned)*

## 🎯 Future Enhancements

- [ ] User authentication and authorization
- [ ] Task categories and tags
- [ ] Due dates and reminders
- [ ] File attachments
- [ ] Real-time notifications
- [ ] Dark mode support
- [ ] Docker containerization
- [ ] CI/CD pipeline

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🔗 Links

- [Live Demo](#) *(Coming Soon)*
- [API Documentation](#) *(Coming Soon)*
- [Project Board](#) *(Coming Soon)*

## 👨‍💻 Developer

Created with ❤️ by **Aditya**

- GitHub: [@21Aditya08](https://github.com/21Aditya08)
- LinkedIn: [Your LinkedIn](https://linkedin.com/in/yourprofile)

---

⭐ **Star this repository if you found it helpful!**

## Overview
Task Manager App is a full‑stack CRUD application to manage tasks with statuses (Pending, In Progress, Completed). It provides a RESTful backend built with Spring Boot and a responsive frontend built with React and TailwindCSS, backed by a MySQL database.

Stack: Spring Boot (Java 17) + React (CRA) + MySQL.

## Features
- Create, view, update, delete tasks
- Status management (Pending, In Progress, Completed)
- Validation on inputs
- Responsive UI with Tailwind
- REST APIs with proper HTTP status codes
- Search tasks by title
- Error handling in backend + toast notifications in frontend

## Tech Stack
- **Backend**: Spring Boot, Spring Data JPA, Hibernate, MySQL
- **Frontend**: React, Axios, React Router, TailwindCSS
- **Tools**: Maven, Docker (optional)

## Project Structure
- Backend → `/task-manager-backend`
- Frontend → `/task-manager-frontend`

## Installation & Setup

### Prerequisites
- Java 17, Maven 3.9+
- Node.js 18+ and npm 9+
- MySQL 8+
- Docker Desktop (optional)

### Backend (Spring Boot)
1) Clone the repository
2) Navigate to `/task-manager-backend`
3) Configure `application.properties` with MySQL credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/task_manager_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

4) Run the backend
   - Dev: `mvn spring-boot:run`
   - Or build jar: `mvn clean package` then run the jar in `target/`

API base URL (default): `http://localhost:8081/api`

### Frontend (React)
1) Navigate to `/task-manager-frontend`
2) Install dependencies: `npm install`
3) Create `.env` (or `.env.local`) and set API base URL:

```env
REACT_APP_API_BASE_URL=http://localhost:8080/api
```

4) Start the app: `npm start` (runs at `http://localhost:3000`)
5) Build for production: `npm run build`

## API Reference
Base URL: `/api`

- `GET /tasks` — List tasks (supports `?title=<query>` to search by title)
- `GET /tasks/{id}` — Get a task by ID
- `POST /tasks` — Create a task
  - Body: `{ "title": string, "description"?: string, "status": "PENDING"|"IN_PROGRESS"|"COMPLETED" }`
- `PUT /tasks/{id}` — Update a task (same body as POST; partial updates optional if implemented)
- `DELETE /tasks/{id}` — Delete a task

Status codes: 200/201/204 on success, 400 for validation errors, 404 if not found, 500 for server errors.

## Data Model (simplified)
Task
- `id`: number (PK)
- `title`: string (required)
- `description`: string (optional)
- `status`: enum [PENDING, IN_PROGRESS, COMPLETED]
- `createdAt` / `updatedAt`: timestamps

## Architecture
- Controller → Service → Repository layering
- Spring Data JPA for persistence (Hibernate under the hood)
- DTOs + validation annotations for input
- Centralized exception handling for consistent error responses
- CORS configured to allow the frontend origin

## Styling & UX
- TailwindCSS for responsive UI
- Toast notifications for success/error feedback in the frontend

## Running with Docker (optional)
You can run MySQL via Docker and point the backend to it.

Example `docker-compose.yml` snippet:

```yaml
version: '3.8'
services:
  db:
    image: mysql:8.0
    environment:
      MYSQL_ROOT_PASSWORD: root
      MYSQL_DATABASE: task_manager_db
    ports:
      - "3306:3306"
    volumes:
      - db_data:/var/lib/mysql
volumes:
  db_data:
```

Then set `spring.datasource.url=jdbc:mysql://localhost:3306/task_manager_db` and credentials accordingly.

## Scripts
- Backend
  - Run: `mvn spring-boot:run`
  - Test: `mvn test`
  - Build: `mvn clean package`
- Frontend
  - Dev: `npm start`
  - Test: `npm test`
  - Build: `npm run build`

## Testing
- Backend: JUnit tests via `mvn test`
- Frontend: React Testing Library/Jest via `npm test`

## Troubleshooting
- MySQL connection: verify credentials, port 3306, and DB exists; ensure `ddl-auto=update` or run migrations.
- CORS issues: confirm backend CORS config includes `http://localhost:3000` in dev.
- Port conflicts: stop processes on 8080/3000 or change the ports.

## Roadmap
- Pagination and sorting
- Due dates and priorities
- Authentication/authorization (JWT)
- Dockerizing backend/frontend services
