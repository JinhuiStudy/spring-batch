FROM openjdk:17-oracle

RUN ln -snf /usr/share/zoneinfo/Asia/Seoul /etc/localtime
RUN echo Asia/Seoul > /etc/timezone

WORKDIR application
ARG JAR_FILE=build/libs/spring-batch-*.jar
COPY ${JAR_FILE} application.jar

ENTRYPOINT ["java","-jar","application.jar"]