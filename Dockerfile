FROM eclipse-temurin:17
WORKDIR /opt/app
RUN apt update && apt install -y curl && apt install -y net-tools && apt install -y iputils-ping
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY ./src ./src
RUN ./mvnw clean install
RUN mkdir /opt/app/dist && mv /opt/app/target/*.jar /opt/app/dist/customer.jar
ENTRYPOINT ["java", "-jar", "/opt/app/dist/customer.jar"]