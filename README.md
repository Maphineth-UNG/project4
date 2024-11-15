## How to Build, Run and Test

### Prerequisites
- Ensure [Gradle](https://gradle.org/install/) is installed.
- Java 21

### Build, Run and Test Commands
1. Install dependencies and build the project:
   ```bash
   ./gradlew build or gradle build
   ```
2. Run the application:
   ```bash
   ./gradlew bootRun or gradle bootRun
   ```	
3. Testing:
   ```bash
   ./gradlew test or gradle test
   ```	


## External Reviewer

1. Plugins
   ```bash
   plugins {
       java
       id("org.springframework.boot") version "3.3.5"
       id("io.spring.dependency-management") version "1.1.6"
   }
   ```	
   - java: Applies the Java plugin, allowing the project to be built as a Java application.
   - org.springframework.boot: Adds support for Spring Boot, allowing the project to leverage Spring Boot's features, including running the app directly from a JAR.
   - io.spring.dependency-management: Ensures that transitive dependencies are managed properly without version conflicts, simplifying the inclusion of various libraries.
   
2. Metadata
   ```bash
   group = "com.example"
   version = "0.0.1-SNAPSHOT"
   ```
   - group: Specifies the base package or organizational namespace for the project (e.g., com.example).
   - version: Indicates the current version of the project (0.0.1-SNAPSHOT), where SNAPSHOT typically means this version is a work in progress.
   
3. Java Toolchain
   ```bash
   java {
       toolchain {
           languageVersion = JavaLanguageVersion.of(21)
       }
   }
   ```
   - Java toolchain: This specifies the version of Java to use for building the project.
   - JavaLanguageVersion.of(21) ensures the project uses Java 21, which allows for using features and syntax available in that version.
   
5. Repositories
   ```bash
   repositories {
       mavenCentral()
   }
   ```
   Repositories: Specifies where Gradle should look for dependencies. mavenCentral() points to Maven Central, a popular repository hosting a vast array of libraries and dependencies.
   
6. Dependencies
   ```bash
   dependencies {
       implementation("org.springframework.boot:spring-boot-starter-web")
       testImplementation("org.springframework.boot:spring-boot-starter-test")
       testRuntimeOnly("org.junit.platform:junit-platform-launcher")
       
       implementation("com.google.code.gson:gson:2.11.0")
   }
   ```
   - implementation("org.springframework.boot:spring-boot-starter-web"): Adds Spring Boot's web starter, which includes essential components like Spring MVC and embedded Tomcat for building web applications.
   - testImplementation("org.springframework.boot:spring-boot-starter-test"): Includes libraries for testing, such as JUnit and Mockito, specifically tailored for Spring Boot applications.
   - testRuntimeOnly("org.junit.platform:junit-platform-launcher"): Specifies that the JUnit Platform Launcher should be available at runtime to discover and execute tests.
   - implementation("com.google.code.gson:gson:2.11.0"): Adds Google's Gson library for handling JSON serialization and deserialization.
   
7. Test Configuration
   ```bash
   tasks.withType<Test> {
       useJUnitPlatform()
   }
   ```
   Test task: Specifies that the project should use the JUnit Platform when running tests. This configuration allows compatibility with JUnit 5 and ensures tests are properly discovered and executed by Gradle.
   
