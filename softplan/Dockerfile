FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/*.jar softplan.jar
RUN bash -c 'touch /softplan.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /softplan.jar"]
 