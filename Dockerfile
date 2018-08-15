FROM java:8-jdk-alpine
#设置时区
ENV  TIME_ZONE Asia/Shanghai
ENV APP_NAME=demo
COPY ./target/${APP_NAME}.jar /data/${APP_NAME}.jar
CMD ["/bin/sh", "java -jar /data/${APP_NAME}.jar"]



