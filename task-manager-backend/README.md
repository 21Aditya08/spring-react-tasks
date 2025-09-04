# Task Manager Backend

Spring Boot (Java 17) REST API for managing tasks. Includes CRUD, search by title, validation, and global error handling.

## Run
- Configure `src/main/resources/application.properties` for MySQL
- Run: `mvn spring-boot:run`

## API
- GET /api/tasks?title=foo
- GET /api/tasks/{id}
- POST /api/tasks
- PUT /api/tasks/{id}
- DELETE /api/tasks/{id}
