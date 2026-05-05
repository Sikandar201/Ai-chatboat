# DevOps Project - AI Chat Assistant

This is a simple Spring Boot application that provides an AI Chat Assistant interface. It includes a frontend for chatting and a status page to view test results.

## Features

- **AI Chat Interface**: A clean, modern chat interface (currently using hardcoded responses for demonstration).
- **Test Status Page**: A dedicated page to run and view the status of backend tests directly from the browser.
- **Responsive Design**: Built with HTML5, CSS3, and Vanilla JavaScript.

## Project Structure

- `src/main/java`: Backend source code (Spring Boot).
  - `controller`: REST controllers for Chat and Test execution.
  - `service`: Business logic.
- `src/main/resources/static`: Frontend assets (HTML, CSS, JS).

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven

### Running the Application

1.  Clone the repository.
2.  Navigate to the project directory.
3.  Run the application using Maven:

    ```bash
    mvn spring-boot:run
    ```

4.  Open your browser and navigate to `http://localhost:8080`.

### Running Tests

You can run tests via the command line:

```bash
mvn test
```

Or, you can view the test status page in the application:
1.  Start the application.
2.  Click "View Tests" in the chat header or navigate to `http://localhost:8080/tests.html`.
3.  Click "Run Tests" to execute the test suite and see the output.

## Configuration

The application is configured via `src/main/resources/application.properties`.
