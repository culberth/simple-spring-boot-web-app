# simple-spring-boot-web-app

A basic Spring Boot web application demonstrating a variety of HTML form controls
(text box, slider, combo box, date picker, radio buttons, checkbox, textarea).
The page submits to a JSON REST endpoint via the Fetch API and reflects the
server's (validated) response back in place, without a full page reload.

## Requirements

- Java 21
- Maven 3.9+

## Tech Stack

| Technology | Purpose |
| --- | --- |
| Java 21 | Backend language |
| Spring Boot 4.1.1 | Application configuration and executable JAR packaging |
| Spring Web MVC | Controllers and request handling, via `spring-boot-starter-web` |
| Embedded Apache Tomcat | HTTP server |
| Thymeleaf | Server-rendered HTML templates, via `spring-boot-starter-thymeleaf` |
| Jakarta Bean Validation | Server-side form validation, via `spring-boot-starter-validation` |
| HTML and CSS | Form controls and page styling |
| Maven | Dependency management and builds |

## Running the app

```bash
mvn spring-boot:run
```

Then open [http://localhost:8082](http://localhost:8082) in your browser.

By default the app listens on port `8082` (configurable via
`server.port` in [`src/main/resources/application.properties`](src/main/resources/application.properties)).

## Screenshot

![Preferences form](docs/images/2026-09-22_21-28-00.png)

## Building a jar

```bash
mvn package
java -jar target/simple-spring-boot-web-app-0.0.1-SNAPSHOT.jar
```

## What it does

The home page (`/`) is a Thymeleaf-served page with a form containing:

- A text box for your name (required)
- A combo box (`<select>`) to pick a favorite language
- A date picker
- A range slider for an enthusiasm score (0-100), with the current value
  updated live as you drag it
- A set of radio buttons to pick a theme preference
- A checkbox to opt in to notifications
- A textarea for freeform notes

Submitting the form sends the values as JSON to `POST /api/demo` via the
Fetch API. The server validates the payload with Jakarta Bean Validation
and echoes it back; the page renders the response in the results panel
without reloading. Client-side JavaScript ([`app.js`](src/main/resources/static/app.js))
also keeps the slider's live percentage in sync and handles the reset button.

## Project structure

```
src/main/java/com/example/demo/
├── DemoApplication.java              # Spring Boot entry point
├── controller/
│   ├── PageController.java           # GET / — renders the Thymeleaf page
│   └── DemoApiController.java        # POST /api/demo — validates and echoes the submission
└── model/
    └── Submission.java               # Validated request/response record

src/main/resources/
├── application.properties
├── static/
│   ├── app.js                        # Form wiring, slider output, Fetch API submission
│   └── styles.css
└── templates/
    └── index.html                    # Form + results page
```
