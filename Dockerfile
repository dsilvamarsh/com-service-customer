FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} com-service-customer.jar
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /com-service-customer.jar"]