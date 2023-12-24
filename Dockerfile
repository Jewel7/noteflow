FROM eclipse-temurin:17-jdk-alpine
#VOLUME /tmp
COPY ./target/*.jar noteflow.jar
# run the noteflow jar within the Docker container
ENTRYPOINT ["java","-jar","/noteflow.jar"]