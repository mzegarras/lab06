FROM maven:3.6.3-jdk-11-slim AS build
WORKDIR /home/app
ADD . /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:11-jre-slim
VOLUME /tmp
RUN export DEBIAN_FRONTEND=noninteractive \
    && apt-get update \
    && apt-get install -y --no-install-recommends \
    && apt-get install -y procps \
    && apt-get install tzdata \
	&& rm -rf /var/lib/apt/lists/*; \
	echo America/Lima > /etc/timezone; \
    rm /etc/localtime; \
	dpkg-reconfigure -fnoninteractive tzdata

COPY --from=build /home/app/target/lab06-*.jar app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]
