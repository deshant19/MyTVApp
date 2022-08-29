FROM openjdk:17-jdk-alpine
VOLUME /tmp
ADD target/MyTVApp-0.0.1-SNAPSHOT.jar mytvapp.jar
ENTRYPOINT ["java","-jar","mytvapp.jar"]