#FROM registry.jr.glodon.com:5000/jr/app_base

ENV APP_NAME=demo
#COPY ./target/${APP_NAME}.jar /data/${APP_NAME}.jar
#CMD ["/bin/sh", "java -jar /data/${APP_NAME}.jar"]

#spring profile
#ENV PROFILE=docker
ENV JAVA_OPTS="-Xverify:none -XX:+TieredCompilation -XX:TieredStopAtLevel=1 "
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=${PROFILE} -jar /data/${APP_NAME}.jar
#HEALTHCHECK CMD curl http://127.0.0.1:8080/go || exit 1
#COPY ./component-web/target/otherlib /data/lib
#COPY ./component-web/target/ownlib /data/lib
COPY ./demo/target/${APP_NAME}.jar /data/${APP_NAME}.jar

