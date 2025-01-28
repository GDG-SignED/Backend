# 1단계: 빌드 단계
FROM gradle:8.11-jdk17 AS builder
WORKDIR /home/gradle/app
COPY . .
RUN ./gradlew bootJar

# 2단계: 실행 단계
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=builder /home/gradle/app/build/libs/*.jar app.jar

# JVM 메모리 설정
ENV JAVA_OPTS="-Xms256m -Xmx512m"

# Spring Boot 프로파일 설정
ENV SPRING_PROFILES_ACTIVE=prod

# 로그 디렉토리 마운트
VOLUME /app/logs

# 포트 노출
EXPOSE 8080

# 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "app.jar", "$JAVA_OPTS"]