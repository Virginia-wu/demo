FROM java:8-jdk-alpine
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone


ENV PROFILE=docker
ENV APP_NAME=demo
ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=${PROFILE} -jar /data/${APP_NAME}.jar
COPY ./target/${APP_NAME}.jar /data/${APP_NAME}.jar



