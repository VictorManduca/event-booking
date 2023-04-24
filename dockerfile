FROM eclipse-temurin:17-alpine
WORKDIR /app
COPY build/libs/event-booking-0.0.1-SNAPSHOT.jar event-booking.jar
ENTRYPOINT ["java", "-jar", "event-booking.jar"]