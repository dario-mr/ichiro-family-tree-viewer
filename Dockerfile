# --- build stage ---
FROM maven:3.9.9-eclipse-temurin-21-jammy AS build
WORKDIR /app

# 1) cache dependencies separately (only reruns when pom.xml changes)
COPY pom.xml .
RUN --mount=type=cache,target=/root/.m2 mvn -B -q -DskipTests dependency:go-offline

# 2) add sources and compile
COPY src ./src
RUN --mount=type=cache,target=/root/.m2 mvn -B -q -DskipTests package

# --- minimal runtime stage ---
FROM gcr.io/distroless/java21-debian12
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]