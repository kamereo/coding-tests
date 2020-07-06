# syntax=docker/dockerfile:experimental
FROM openjdk:11 AS build

ARG AWS_DEFAULT_REGION
ARG AWS_ACCESS_KEY_ID
ARG AWS_SECRET_ACCESS_KEY
ARG AWS_SESSION_TOKEN

WORKDIR /app

# Gradle installation
COPY gradlew ./gradlew
COPY gradle ./gradle
RUN --mount=type=cache,id=gradle,target=/root/.gradle ./gradlew --no-daemon

# Gradle settings
COPY settings.gradle build.gradle ./

# Sources
COPY src ./src

# Build boot jar
RUN --mount=type=cache,id=gradle,target=/root/.gradle ./gradlew --no-daemon -i bootJar

FROM openjdk:11-jre-slim

ADD https://search.maven.org/remotecontent?filepath=co/elastic/apm/elastic-apm-agent/1.13.0/elastic-apm-agent-1.13.0.jar /app/elastic-apm-agent.jar
ADD https://github.com/grpc-ecosystem/grpc-health-probe/releases/download/v0.3.1/grpc_health_probe-linux-amd64 /bin/grpc_health_probe
RUN chmod +x /bin/grpc_health_probe

COPY docker/run.sh /app/run.sh
ENTRYPOINT [ "/app/run.sh" ]

EXPOSE 50051
COPY --from=build /app/build/libs/*.jar /app/application.jar
