#!/bin/sh

while ! `nc -z $CONFIGSERVER_HOST $CONFIGSERVER_PORT`; do 
    echo "********************************************************"
    echo "Waiting for $CONFIGSERVER_HOST to start on port $CONFIGSERVER_PORT"
    echo "********************************************************"
    sleep 20
done

echo "Config Server up and running at $CONFIGSERVER_HOST:$CONFIGSERVER_PORT"


while ! `nc -z $USERSERVER_HOST $USERSERVER_PORT`; do 
    echo "********************************************************"
    echo "Waiting for $USERSERVER_HOST to start on port $USERSERVER_PORT"
    echo "********************************************************"
    sleep 20
done

echo "User Server up and running at $USERSERVER_HOST:$USERSERVER_PORT"


while ! `nc -z $DATABASE_HOST $DATABASE_PORT`; do 
    echo "********************************************************"
    echo "Waiting for $DATABASE_HOST to start on port $DATABASE_PORT"
    echo "********************************************************"
    sleep 20
done

echo "MySQL server up and running at $DATABASE_HOST:$DATABASE_PORT"

java -Djava.security.egd=file:/dev/./urandom -Dspring.cloud.config.uri=$SHAREWOOD_CONFIG_URI -Dspring.profiles.active=$PROFILE -jar /app.jar
