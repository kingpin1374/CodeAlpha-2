# Automated Java CI/CD Pipeline & Containerization

========================================================================
PROJECT OVERVIEW
========================================================================
This repository contains the implementation for Task 3 of the CodeAlpha 
DevOps Internship. It demonstrates the end-to-end automation, 
containerization, and continuous integration of a Java-based web 
application using Gradle and Docker.

The primary objective is to apply core DevOps principles to streamline 
build processes, manage dependencies efficiently, and establish a 
robust path to production.

========================================================================
FEATURES & DEVOPS PRINCIPLES APPLIED
========================================================================
- Infrastructure as Code (IaC): Multi-stage Dockerfile defining both 
  the build and runtime environments.
- Dependency Management: Managed efficiently via Gradle (build.gradle).
- Multi-Stage Docker Builds: Separates bulky JDK/Gradle build tools 
  from the final lightweight JRE 21 production environment (Ubuntu 
  Jammy-based).
- Environment Isolation: Strict .dockerignore implementation to 
  prevent host-machine artifact bleeding (preventing version errors).
- CI/CD Ready: Structured for seamless integration with GitHub 
  Actions for automated testing and image building.

========================================================================
PREREQUISITES
========================================================================
- Docker: Ensure the Docker daemon is installed and running.
- Java 21 & Gradle: (Optional, for local development) 

========================================================================
QUICK START (DOCKER DEPLOYMENT)
========================================================================
1. Build the Docker Image:
   docker build -t my-java-app .

2. Run the Container:
   docker run -d -p 8080:8080 --name running-java-app my-java-app

3. Access the Application:
   Open your browser and navigate to: http://localhost:8080

========================================================================
PROJECT STRUCTURE
========================================================================
.
├── .dockerignore           # Prevents host build artifacts from leak
├── Dockerfile              # Multi-stage container (JDK 21 -> JRE 21)
├── app/
│   ├── build.gradle        # Gradle configuration
│   └── src/main/java/...   # Java source code (HTTP Server)
└── .github/workflows/      # GitHub Actions CI/CD configuration

========================================================================
CI/CD PIPELINE INTEGRATION
========================================================================
This project is configured for GitHub Actions. A standard pipeline 
would execute the following on every commit to the main branch:
1. Checkout source code.
2. Setup Java 21 and Gradle environment.
3. Execute './gradlew build' to verify integrity and run tests.
4. Build and tag the Docker image.

------------------------------------------------------------------------
Developed as part of the CodeAlpha DevOps Internship program.
========================================================================
# CodeAlpha-2
