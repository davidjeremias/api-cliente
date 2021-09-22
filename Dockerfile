FROM adoptopenjdk/openjdk11:ubi

EXPOSE 8080

RUN mkdir /opt/app

ADD target/cliente.jar /opt/app

ENTRYPOINT ["java", "-jar", "/opt/app/cliente.jar"]