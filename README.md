# Note-Taking Markdown API

This is a REST API developed with **Java 21** and **Spring Boot 4.x** for managing notes. The key feature of this application is its ability to receive Markdown-formatted text, process it, and deliver the converted content into valid HTML tags.

The project was built following the specifications of the [Markdown Note-Taking App](https://roadmap.sh/projects/markdown-note-taking-app) challenge from Roadmap.sh.

---

### 🚀 Technologies Used

*   **Java 21** - The LTS version of the Java ecosystem.
*   **Spring Boot 4.x** - The core of the backend ecosystem.
    *   *Spring Data JPA:* Persistence layer and object-relational mapping.
    *   *Spring WebMVC:* RESTful architecture and endpoint handling.
    *   *Spring Boot DevTools:* Live-reload tools for development productivity.
*   **Commonmark (v0.30.0)** - A robust library used to parse and render Markdown to HTML efficiently.
*   **H2 Database** - An in-memory SQL database, perfect for rapid execution in development environments.
*   **Project Lombok** - Automation of boilerplate code (getters, setters, constructors).
*   **Maven** - Dependency management and project build tool.

---

### 🗺️ API Endpoints

*(Note: Adjust the URLs and fields below if you used different paths or names in your Controller)*

#### 1. Create a New Note (Process Markdown)
Saves the note to the database and returns the original content along with the generated HTML.

*   **Method:** `POST`
*   **URL:** `/api/notes`
*   **Headers:** `Content-Type: application/json`
*   **Request Body:**
    ```json
    {
      "content": "# Hello World\n\nThis is a **bold** text using *Markdown*."
    }
    ```
*   **Response Body (`201 Created` or `200 OK`):**
    ```json
    {
      "id": 1,
      "title": "My first note",
      "content": "# Hello World\n\nThis is a **bold** text using *Markdown*.",
      "htmlContent": "<h1>Hello World</h1>\n<p>This is a <strong>bold</strong> text using <em>Markdown</em>.</p>\n"
    }
    ```

#### 2. List All Notes
Retrieves the history of all notes saved in the H2 database.

*   **Method:** `GET`
*   **URL:** `/api/notes`
*   **Response Body (`200 OK`):**
    ```json
    [
      {
        "id": 1,
        "title": "My first note",
        "htmlContent": "<h1>Hello World</h1>..."
      }
    ]
    ```

---

#### 3. List Note By Id
Retrieves a single note from the database by its unique identifier.

*   **Method:** `GET`
*   **URL:** `/api/notes/{id}`
*   **Response Body (`200 OK`):**
    ```json
    {
      "id": 1,
      "title": "My first note",
      "content": "# Hello World\n\nThis is a **bold** text using *Markdown*.",
      "htmlContent": "<h1>Hello World</h1>\n<p>This is a <strong>bold</strong> text using <em>Markdown</em>.</p>\n"
    }
    ```

---

### 💻 How to Run the Application Locally

#### Prerequisites
*   **JDK 21** installed on your system.
*   **Maven 3.x** installed (or use the provided `./mvnw` wrapper).

#### Step-by-Step

1. **Clone the Repository:**
   ```bash
   git clone https://github.com
   cd note-taking-md
   ```

2. **Compile and Run the Project:**
   ```bash
   ./mvnw spring-boot:run
   ```
   The application will start by default on port `8080`.
