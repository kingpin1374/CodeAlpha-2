# Stage 1: Build the application with JDK 21
FROM gradle:8.5-jdk21 AS build
WORKDIR /app
COPY . .
RUN gradle installDist -x test --no-daemon

# Stage 2: Production Image with JRE 21
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
COPY --from=build /app/app/build/install/app /app/

EXPOSE 8080

CMD ["/app/bin/app"]
