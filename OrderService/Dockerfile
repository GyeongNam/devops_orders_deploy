#FROM openjdk:17-jdk-alpine AS stage1
#
#COPY gradlew .
#COPY gradle gradle
#COPY build.gradle .
#COPY settings.gradle .
#COPY src src
#RUN chmod +x ./gradlew
#RUN ./gradlew bootJar
#
## app/build/libs/*.jar 파일 아래 명령어를 통해 실행
#
#RUN ./gradlew bootJar
#
#FROM openjdk:17-jdk-alpine
#
#WORKDIR /app
#
##COPY build/libs/*.jar app.jar
#
#COPY --from=stage1 /app/build/libs/*.jar /app/app.jar
#
## CMD 또는 ENTRYPOINT를 통해 컨테이너 실행
#
#ENTRYPOINT ["java", "-jar", "app.jar"]

FROM openjdk:17-jdk-alpine as stage1
WORKDIR /app
# gradle빌드시에 필요한 파일들을 workdir로 copy
# /app/gradlw파일, gradle폴더, build.gradle파일...
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src
# /app/build/libs/*.jar 파일 아래 명령어를 통해 생성
RUN ./gradlew bootJar
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=stage1 /app/build/libs/*.jar app.jar
# docker run -d -p 8080:8080 -v C:/Users/Playdata/Desktop/tmp:/tmp ordering:v1
# volume을 잡아준다: 전체 host의 특정 경로와 매핑을 시킴
VOLUME /tmp
# CMD 또는 ENTRYPOINT를 통해 컨테이너 실행
ENTRYPOINT [ "java", "-jar", "app.jar" ]


