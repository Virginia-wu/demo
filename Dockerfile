FROM java:8-jdk-alpine
#设置时区
ENV  TIME_ZONE Asia/Shanghai

ENV PROFILE=docker
ENV APP_NAME=demo
ENV JAVA_OPTS=""
HEALTHCHECK CMD curl --fail http://127.0.0.1:8080/go || exit 1
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=${PROFILE} -jar /data/${APP_NAME}.jar
COPY ./target/${APP_NAME}.jar /data/${APP_NAME}.jar



