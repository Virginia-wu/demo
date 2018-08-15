FROM java:8-jdk-alpine
ENV  TIME_ZONE Asia/Shanghai

ENV PROFILE=docker
ENV APP_NAME=demo
ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=${PROFILE} -jar /data/${APP_NAME}.jar
COPY ./target/${APP_NAME}.jar /data/${APP_NAME}.jar



