# Utiliser une image de base officielle de Java avec Maven
FROM maven:3.6.3-jdk-11 AS build

# Copier les fichiers de l'application dans le conteneur
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app

# Compiler l'application
RUN mvn -f /usr/src/app/pom.xml clean package

# Utiliser une image de base de Java pour l'exécution
FROM openjdk:11-jre-slim

# Copier le JAR compilé depuis l'étape de construction
COPY --from=build /usr/src/app/target/my-application.jar /usr/app/my-application.jar

# Exposer le port sur lequel l'application va tourner
EXPOSE 8080

# Lancer l'application Java
CMD ["java", "-jar", "/usr/app/my-application.jar"]
