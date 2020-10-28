FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq

# Workspace (image location)
WORKDIR /usr/share/udemy

# ADD .jar under target from host
# into this image
ADD target/selenium-docker.jar 			  selenium-docker.jar
ADD target/selenium-docker-tests.jar 	selenium-docker-tests.jar
ADD target/libs							          libs

# in case of any other dependency like .csv / .json / .xls
# please ADD that as well

# ADD suite files
ADD book-flight-module.xml				book-flight-module.xml
ADD search-module.xml					    search-module.xml

# ADD health check script, which will also run the ENTRYPOINT.
ADD healthcheck.sh                      healthcheck.sh

# BROWSER
# HUB_HOST
# MODULE

#ENTRYPOINT will change. It will just run the health check.sh which eventually run the #test

ENTRYPOINT sh healthcheck.sh
