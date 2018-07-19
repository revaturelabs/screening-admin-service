FROM openjdk:8-jdk-alpine
ADD . /ScreeningAdminService
WORKDIR /ScreeningAdminService
CMD ["java", "-jar", "target/screening-admin-service.jar"]