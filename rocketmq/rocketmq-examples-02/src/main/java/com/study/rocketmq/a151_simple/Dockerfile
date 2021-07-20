FROM java:8
MAINTAINER zhou 984144011@qq.com
VOLUME /tmp
RUN mkdir /app
ADD target/dis/ /app/
RUN bash -c 'mv /target/dis/wisdom-hospital-sys-0.0.1-SNAPSHOT.jar /app/app.jar'
WORKDIR /app
ENV JAVA_OPTS="-Duser.timezone=Asia/Shanghai -Djava.security.egd=file:/dev/./urandom"
EXPOSE 2020
ENV APP_OPTS=""
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app/app.jar $APP_OPTS"]
