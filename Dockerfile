FROM eclipse-temurin:17-jdk-alpine
#VOLUME /tmp
COPY ./target/*.jar noteflow.jar
ENTRYPOINT ["java","-jar","/noteflow.jar"]