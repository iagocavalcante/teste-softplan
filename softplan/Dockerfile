FROM java:8
VOLUME /tmp
ADD target/siegen-0.0.1.jar softplan.jar
RUN bash -c 'touch /softplan.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /softplan.jar"]
 
