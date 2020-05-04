FROM openjdk:8 AS Build
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY build.gradle settings.gradle gradlew $APP_HOME
COPY gradle $APP_HOME/gradle
RUN ./gradlew build || return 0 
COPY . .
RUN ./gradlew build

FROM openjdk:8
ENV ARTIFACT_NAME=portfolio-api-1.0-SNAPSHOT.jar
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY --from=Build $APP_HOME/build/libs/$ARTIFACT_NAME .
EXPOSE 5000
CMD ["java","-jar","portfolio-api-1.0-SNAPSHOT.jar"]