FROM openjdk:8-jdk-alpine
ADD . /ScreeningAdminService
WORKDIR /ScreeningAdminService
ARG SCREENFORCE_CONFIG_SERVER_URL
ARG CALIBER_EUREKA_SERVER_URL
ENV SCREENFORCE_CONFIG_SERVER_URL $SCREENFORCE_CONFIG_SERVER_URL
ENV CALIBER_EUERKA_SERVER_URL $CALIBER_EUREKA_SERVER_URL
CMD ["java", "-jar", "target/screening-admin-service.jar"]