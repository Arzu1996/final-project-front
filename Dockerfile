FROM openjdk:11.0-jdk-slim

ENV API_SERVER_PORT=9090
ENV MANAGEMENT_SERVER_PORT=9091
ENV JAVA_OPTS=""
EXPOSE 9090 9091
USER 1001
COPY build/libs/frontend-0.0.1-SNAPSHOT.jar frontend-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-XX:+UseContainerSupport", "-XX:MaxRAMPercentage=75", "-jar", "frontend-0.0.1-SNAPSHOT.jar"]
